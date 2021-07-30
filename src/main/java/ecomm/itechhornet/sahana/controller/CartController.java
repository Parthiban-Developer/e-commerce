package ecomm.itechhornet.sahana.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ecomm.itechhornet.sahana.dto.ApiResponse;
import ecomm.itechhornet.sahana.entity.Cart;
import ecomm.itechhornet.sahana.service.CartService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "E-commerce cart service is running, "+ System.currentTimeMillis();
	}
	
	
	// add/update item to cart
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ApiResponse addCartItems(@RequestBody Cart cart) {
		return cartService.addCartItems(cart);
	}
	
	// get cart items
	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public ApiResponse getCartItems(@PathVariable String cartId) {
		return cartService.getCartItems(cartId);
	}
	
	// remove item from cart
	@RequestMapping(value = "/{cartId}/{cartItemId}", method = RequestMethod.DELETE)
	public ApiResponse deleteCartItem(@PathVariable String cartId , @PathVariable String cartItemId) {
		return cartService.deleteCartItem(cartId, cartItemId);
	}
		
}
