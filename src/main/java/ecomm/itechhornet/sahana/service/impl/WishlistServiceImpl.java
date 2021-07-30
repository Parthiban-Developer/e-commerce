package ecomm.itechhornet.sahana.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import ecomm.itechhornet.sahana.dto.ApiResponse;
import ecomm.itechhornet.sahana.entity.Cart;
import ecomm.itechhornet.sahana.entity.CartItem;
import ecomm.itechhornet.sahana.entity.Customer;
import ecomm.itechhornet.sahana.entity.Image;
import ecomm.itechhornet.sahana.entity.ProductDetails;
import ecomm.itechhornet.sahana.entity.Wishlist;
import ecomm.itechhornet.sahana.entity.WishlistItem;
import ecomm.itechhornet.sahana.repository.CustomerRepository;
import ecomm.itechhornet.sahana.repository.ImageRepository;
import ecomm.itechhornet.sahana.repository.ProductDetailsRepository;
import ecomm.itechhornet.sahana.repository.WishlistRepository;
import ecomm.itechhornet.sahana.service.WishlistService;

@Component
public class WishlistServiceImpl implements WishlistService {

	ObjectMapper om = new ObjectMapper();

	@Autowired
	WishlistRepository wishlistRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ProductDetailsRepository productDetailsRepository;

	@Autowired
	ImageRepository imageRepository;

	@Override
	public ApiResponse addWishlistItems(Wishlist whishlist) {
		if (whishlist.getCustomer() == null || whishlist.getCustomer().getId() == null || whishlist.getCustomer().getId() == 0) {
			return new ApiResponse("404", "Customer Id is required.", null);
		} else if (whishlist.getId() == null || whishlist.getId() == 0) {
			// registered user but new wishlist
			Long custId = whishlist.getCustomer().getId();
			Optional<Customer> cust = customerRepository.findById(custId);
			if (cust.isEmpty()) {
				return new ApiResponse("404", "Not a registered customer: " + whishlist.getCustomer().getId(), null);
			}
			return createWishlist(cust.get(), whishlist);
		} else {
			// registered user and existing wishlist
			return addWishlsitItem(whishlist);
		}
	}

	@Override
	public ApiResponse getWishlistItems(String wishlistId) {
		Optional<Wishlist> wishlistOpt = wishlistRepository.findById(Long.valueOf(wishlistId));

		if (wishlistOpt.isEmpty()) {
			return new ApiResponse("404", "Could not find this wishlist: " + wishlistId, null);
		}
		return new ApiResponse("200", "Wishlist and wishlist items", wishlistOpt.get());
	}

	@Override
	public ApiResponse deleteWishlistItem(String wishlistId, String wishlistItemId) {
		Optional<Wishlist> wishlistOpt = wishlistRepository.findById(Long.valueOf(wishlistId));
		if (wishlistOpt.isEmpty()) {
			return new ApiResponse("404", "Could not find this wishlist: " + wishlistId, null);
		}
		
		Wishlist WishlistDb = wishlistOpt.get();
		List<WishlistItem> wishlistItems = WishlistDb.getWishlistItems();
		if (wishlistItems.isEmpty()) {
			return new ApiResponse("404", "Could not find wishlist items in this wishlist: " + wishlistId, null);
		}
		
		Iterator<WishlistItem> i = wishlistItems.iterator();
		WishlistItem wItemObj = null;
		while (i.hasNext()) {
			WishlistItem wi = i.next();
		   if(wi.getId() == Long.valueOf(wishlistItemId)) {
			   wItemObj = wi;
		   }
		}
		
		if(wItemObj != null)
			WishlistDb.getWishlistItems().remove(wItemObj);
		
		wishlistRepository.save(WishlistDb);
		
		return new ApiResponse("200", "Cart Item has been deleted, id: "+wishlistItemId, null);
	}

	// Create Wishlist
	private ApiResponse createWishlist(Customer cust, Wishlist whishlist) {
		Wishlist wishlistResp = null;
		//CartDto cartDto = null;

		whishlist.setCustomer(cust);

		whishlist.getWishlistItems().forEach(wli -> {
			ProductDetails pd = productDetailsRepository.findById(wli.getProductDetails().getId()).get();
			wli.setProductDetails(pd);

			Image img = imageRepository.findById(wli.getProductDetails().getId()).get();
			wli.setImage(img);
		});
		wishlistResp = wishlistRepository.save(whishlist);
		//cartDto = om.convertValue(cartResp, CartDto.class);
		return new ApiResponse("200", "Wishlist has been created.", wishlistResp);
	}
	
	// Add wishlist items
	private ApiResponse addWishlsitItem(Wishlist whishlist) {
		Optional<Wishlist> wishlistOpt = wishlistRepository.findById(whishlist.getId());

		if (wishlistOpt.isEmpty()) {
			return new ApiResponse("404", "Could not find this wishlsit: " + whishlist.getId(), null);
		}
		Wishlist whishlistDB = wishlistOpt.get();

		whishlist.getWishlistItems().forEach(wli -> {
			ProductDetails pd = productDetailsRepository.findById(wli.getProductDetails().getId()).get();
			wli.setProductDetails(pd);

			Image img = imageRepository.findById(wli.getImage().getId()).get();
			wli.setImage(img);
		});

		addWishlsitItem(whishlist, whishlistDB);
		Wishlist wishlistResp = wishlistRepository.save(whishlistDB);
		//CartDto cartDto = om.convertValue(cartResp, CartDto.class);
		return new ApiResponse("202", "Wishlist Item has been added.", wishlistResp);
	}
	
	// This method add wishlist items if already exist.
	private void addWishlsitItem(Wishlist whishlist, Wishlist wishlistDB) {
		// Check if the product details already existing
		List<WishlistItem> wishlistItems = new ArrayList<>();
		
		if (wishlistDB.getWishlistItems() != null) {
			for (WishlistItem wli : whishlist.getWishlistItems()) {
				boolean itemPresent = false;
				for (WishlistItem wliDB : wishlistDB.getWishlistItems()) {
					if (wli.getProductDetails().getId() == wliDB.getProductDetails().getId()) {
						itemPresent = true;	
					}
				}
				if (!itemPresent) {
					wishlistItems.add(wli);
				}
			};
		} else {
			wishlistDB.getWishlistItems().addAll(wishlistDB.getWishlistItems());
		}
		wishlistDB.getWishlistItems().addAll(wishlistItems);
	}
}