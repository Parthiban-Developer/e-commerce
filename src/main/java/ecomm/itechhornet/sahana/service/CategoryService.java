package ecomm.itechhornet.sahana.service;

import org.springframework.stereotype.Service;

import ecomm.itechhornet.sahana.dto.ApiResponse;
import ecomm.itechhornet.sahana.request.ProductListRequest;

@Service
public interface CategoryService {

	ApiResponse getProductList(ProductListRequest plReq);

}
