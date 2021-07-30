package ecomm.itechhornet.sahana.service;

import org.springframework.stereotype.Service;

import ecomm.itechhornet.sahana.dto.ApiResponse;
import ecomm.itechhornet.sahana.entity.Wishlist;

@Service
public interface WishlistService {

	ApiResponse addWishlistItems(Wishlist whishlist);

	ApiResponse getWishlistItems(String wishlistId);

	ApiResponse deleteWishlistItem(String wishlistId, String wishlistItemId);

}
