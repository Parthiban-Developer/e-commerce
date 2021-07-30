package ecomm.itechhornet.sahana.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ecomm.itechhornet.sahana.dto.ApiResponse;
import ecomm.itechhornet.sahana.entity.Wishlist;
import ecomm.itechhornet.sahana.service.WishlistService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/wishlist")
public class WishlistController {

	@Autowired
	WishlistService wishlistService;
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "E-commerce wishlist service is running, "+ System.currentTimeMillis();
	}
	
	
	// add/update item to cart
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ApiResponse addWishlistItems(@RequestBody Wishlist whishlist) {
		return wishlistService.addWishlistItems(whishlist);
	}
	
	// get cart items 
	@RequestMapping(value = "/{wishlistId}", method = RequestMethod.GET)
	public ApiResponse getCartItems(@PathVariable String wishlistId) {
		return wishlistService.getWishlistItems(wishlistId);
	}
	
	// remove item from cart
	@RequestMapping(value = "/{wishlistId}/{wishlistItemId}", method = RequestMethod.DELETE)
	public ApiResponse deleteCartItem(@PathVariable String wishlistId , @PathVariable String wishlistItemId) {
		return wishlistService.deleteWishlistItem(wishlistId, wishlistItemId);
	}
		
}
