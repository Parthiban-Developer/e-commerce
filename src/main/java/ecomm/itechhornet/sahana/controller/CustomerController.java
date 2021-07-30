package ecomm.itechhornet.sahana.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ecomm.itechhornet.sahana.dto.ApiResponse;
import ecomm.itechhornet.sahana.entity.Customer;
import ecomm.itechhornet.sahana.request.LoginRequest;
import ecomm.itechhornet.sahana.service.CustomerService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "E-commerce customer service is running, "+ System.currentTimeMillis();
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ApiResponse registerUser(@RequestBody Customer customer) {
		return customerService.registerUser(customer);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ApiResponse registerUser(@PathVariable String id, @RequestBody Customer customer) {
		return customerService.updateUser(id, customer);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ApiResponse registerUser(@RequestBody LoginRequest login) {
		return customerService.login(login);
	}
}
