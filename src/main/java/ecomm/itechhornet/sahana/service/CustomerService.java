package ecomm.itechhornet.sahana.service;

import org.springframework.stereotype.Service;

import ecomm.itechhornet.sahana.dto.ApiResponse;
import ecomm.itechhornet.sahana.entity.Customer;
import ecomm.itechhornet.sahana.request.LoginRequest;

@Service
public interface CustomerService {
	
	ApiResponse registerUser(Customer customer);

	ApiResponse updateUser(String id, Customer customer);

	ApiResponse login(LoginRequest login);
	
}
