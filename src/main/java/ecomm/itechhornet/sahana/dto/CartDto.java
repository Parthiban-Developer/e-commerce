package ecomm.itechhornet.sahana.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ecomm.itechhornet.sahana.entity.CartItem;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartDto {

	Long id;
	
	String shippingCharge;
	
	String otherCharges;
	
	CustomerDto customer;
	
	List<CartItem> cartItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		
}
