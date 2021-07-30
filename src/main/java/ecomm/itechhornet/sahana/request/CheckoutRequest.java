package ecomm.itechhornet.sahana.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ecomm.itechhornet.sahana.dto.CustomerDto;
import ecomm.itechhornet.sahana.entity.CartItem;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckoutRequest {

	String shippingCharge;
	
	String otherCharges;
	
	CustomerDto customer;
	
	Long cartId;
	
	List<CartItem> cartItems;

	public String getShippingCharge() {
		return shippingCharge;
	}

	public void setShippingCharge(String shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	public String getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(String otherCharges) {
		this.otherCharges = otherCharges;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
		
}
