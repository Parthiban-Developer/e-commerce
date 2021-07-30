package ecomm.itechhornet.sahana.service;

import org.springframework.stereotype.Service;

import ecomm.itechhornet.sahana.dto.ApiResponse;
import ecomm.itechhornet.sahana.entity.Cart;

@Service
public interface CartService {

	ApiResponse addCartItems(Cart cart);

	ApiResponse getCartItems(String cartId);

	ApiResponse deleteCartItem(String cartItemId, String cartItemId2);

}
