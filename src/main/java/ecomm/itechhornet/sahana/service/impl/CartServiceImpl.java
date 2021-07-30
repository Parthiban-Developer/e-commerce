package ecomm.itechhornet.sahana.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import ecomm.itechhornet.sahana.dto.ApiResponse;
import ecomm.itechhornet.sahana.dto.CartDto;
import ecomm.itechhornet.sahana.entity.Cart;
import ecomm.itechhornet.sahana.entity.CartItem;
import ecomm.itechhornet.sahana.entity.Customer;
import ecomm.itechhornet.sahana.entity.Image;
import ecomm.itechhornet.sahana.entity.ProductDetails;
import ecomm.itechhornet.sahana.repository.CartRepository;
import ecomm.itechhornet.sahana.repository.CustomerRepository;
import ecomm.itechhornet.sahana.repository.ImageRepository;
import ecomm.itechhornet.sahana.repository.ProductDetailsRepository;
import ecomm.itechhornet.sahana.request.CheckoutRequest;
import ecomm.itechhornet.sahana.service.CartService;

@Component
public class CartServiceImpl implements CartService {

	ObjectMapper om = new ObjectMapper();

	@Autowired
	CartRepository cartRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ProductDetailsRepository productDetailsRepository;

	@Autowired
	ImageRepository imageRepository;

	@Override
	public ApiResponse addCartItems(Cart cart) {

		if (cart.getCustomer() == null || cart.getCustomer().getId() == null || cart.getCustomer().getId() == 0) {
			return createCart(createCustomer(), cart);
		} else if (cart.getId() == null || cart.getId() == 0) {
			// registered user but new cart
			Long custId = cart.getCustomer().getId();
			Optional<Customer> cust = customerRepository.findById(custId);
			if (cust.isEmpty()) {
				return new ApiResponse("404", "Not a registered customer: " + cart.getCustomer().getId(), null);
			}
			return createCart(cust.get(), cart);
		} else {
			// registered user and existing cart
			return updateOrAddCartItem(cart);
		}

	}

	@Override
	public ApiResponse getCartItems(String cartId) {
		Optional<Cart> cartOpt = cartRepository.findById(Long.valueOf(cartId));

		if (cartOpt.isEmpty()) {
			return new ApiResponse("404", "Could not find this cart: " + cartId, null);
		}
		return new ApiResponse("200", "Cart and cart items", cartOpt.get());
	}

	@Override
	public ApiResponse deleteCartItem(String cartId, String cartItemId) {
		Optional<Cart> cartOpt = cartRepository.findById(Long.valueOf(cartId));
		if (cartOpt.isEmpty()) {
			return new ApiResponse("404", "Could not find this cart: " + cartId, null);
		}
		
		Cart cartDb = cartOpt.get();
		List<CartItem> cartItems = cartDb.getCartItems();
		if (cartItems.isEmpty()) {
			return new ApiResponse("404", "Could not find cart items in this cart: " + cartId, null);
		}
		
		Iterator<CartItem> i = cartItems.iterator();
		CartItem cItemObj = null;
		while (i.hasNext()) {
		   CartItem ci = i.next();
		   if(ci.getId() == Long.valueOf(cartItemId)) {
			   cItemObj = ci;
		   }
		}
		
		if(cItemObj != null)
			cartDb.getCartItems().remove(cItemObj);
		
		cartRepository.save(cartDb);
		
		return new ApiResponse("200", "Cart Item has been deleted, id: "+cartItemId, null);
	}

	// Update Cart items or add cart items
	private ApiResponse updateOrAddCartItem(Cart cart) {
		Optional<Cart> cartOpt = cartRepository.findById(cart.getId());

		if (cartOpt.isEmpty()) {
			return new ApiResponse("404", "Could not find this cart: " + cart.getId(), null);
		}
		Cart cartDB = cartOpt.get();
		cartDB.setShippingCharge(cart.getShippingCharge());
		cartDB.setOtherCharges(cart.getOtherCharges());

		cart.getCartItems().forEach(ci -> {
			ProductDetails pd = productDetailsRepository.findById(ci.getProductDetails().getId()).get();
			ci.setProductDetails(pd);

			Image img = imageRepository.findById(ci.getImage().getId()).get();
			ci.setImage(img);
		});

		updateExistingorAddCartItem(cart, cartDB);
		Cart cartResp = cartRepository.save(cartDB);
		CartDto cartDto = om.convertValue(cartResp, CartDto.class);
		return new ApiResponse("202", "Cart Item has been added.", cartDto);
	}

	// This method update cart item quantity if alreay exist or add the cart items.
	private void updateExistingorAddCartItem(Cart cart, Cart cartDB) {
		// Check if the product details already existing and quantity not exceeds
		// available qty.
		List<CartItem> cartItems = new ArrayList<>();
		// boolean lastElem = false;
		if (cartDB.getCartItems() != null) {
			// int idx = cartDB.getCartItems().size();
			for (CartItem c : cart.getCartItems()) {
				boolean itemPresent = false;
				for (CartItem cDB : cartDB.getCartItems()) {
					Long cId = c.getProductDetails().getId();
					if (cId == cDB.getProductDetails().getId()) {
						itemPresent = true;
						int totalQty = cDB.getQty() + c.getQty();
						if (totalQty < cDB.getProductDetails().getAvailQty()) {
							cDB.setQty(cDB.getQty() + c.getQty());
						} else {
							cDB.setQty(cDB.getProductDetails().getAvailQty());
						}
					} else {
						// } else if(!lastElem) {
						// lastElem = (cartDB.getCartItems().size()-1 == idx) ? true : false;

					}
				}
				;
				if (!itemPresent) {
					cartItems.add(c);
				}
			}
			;
		} else {
			cartDB.getCartItems().addAll(cart.getCartItems());
		}

		cartDB.getCartItems().addAll(cartItems);
	}

	// Create user for non-registered customer
	private Customer createCustomer() {
		Customer customer = new Customer();
		customer.setRegUser(false);
		return customerRepository.save(customer);
	}

	// Create cart
	private ApiResponse createCart(Customer cust, Cart cart) {
		Cart cartResp = null;
		CartDto cartDto = null;

		cart.setCustomer(cust);

		cart.getCartItems().forEach(ci -> {
			ProductDetails pd = productDetailsRepository.findById(ci.getProductDetails().getId()).get();
			ci.setProductDetails(pd);

			Image img = imageRepository.findById(ci.getProductDetails().getId()).get();
			ci.setImage(img);
		});
		cartResp = cartRepository.save(cart);
		cartDto = om.convertValue(cartResp, CartDto.class);
		return new ApiResponse("200", "Cart has been created.", cartDto);
	}

	// Checkout - Update Cart details and get Customer details
	public ApiResponse checkoutService(CheckoutRequest checkout) {
		
		checkout.getCustomer().getId();
		if (checkout.getCustomer() == null || checkout.getCustomer().getId() == null || checkout.getCustomer().getId() == 0) {
			return new ApiResponse("400", "Customer id should not be empty.", null);
		}
		
		Long custId = checkout.getCustomer().getId();
		Optional<Customer> cust = customerRepository.findById(custId);
		if (cust.isEmpty()) {
			return new ApiResponse("404", "Customer is not registered : " + custId, null);
		}
		
		cust.get().getBilladdress();
		
		Long cartId = checkout.getCartId();
		if (cartId == null || cartId == 0) {
			return new ApiResponse("400", "Cart id should not be empty.", null);
		}
		
		ApiResponse cartItems = getCartItems(cartId.toString());

		if(cartItems.getData() == null) {
			return new ApiResponse("404", "Cart is not found : " + cartId, null);
		}
		checkout.getCartItems();
		
		return null;
	}
}