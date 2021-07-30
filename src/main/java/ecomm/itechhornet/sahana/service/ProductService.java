package ecomm.itechhornet.sahana.service;

import org.springframework.stereotype.Service;

import ecomm.itechhornet.sahana.dto.ApiResponse;

@Service
public interface ProductService {

	ApiResponse getProductById(int id);

}
