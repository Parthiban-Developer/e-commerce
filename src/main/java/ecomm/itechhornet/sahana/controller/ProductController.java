package ecomm.itechhornet.sahana.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ecomm.itechhornet.sahana.dto.ApiResponse;
import ecomm.itechhornet.sahana.service.ProductService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "E-commerce product service is running, "+ System.currentTimeMillis();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ApiResponse getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
		
}
