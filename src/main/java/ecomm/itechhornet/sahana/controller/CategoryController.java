package ecomm.itechhornet.sahana.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ecomm.itechhornet.sahana.dto.ApiResponse;
import ecomm.itechhornet.sahana.request.ProductListRequest;
import ecomm.itechhornet.sahana.service.CategoryService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "E-commerce service is running, "+ System.currentTimeMillis();
	}
	
	@RequestMapping(value = "/getProductList", method = RequestMethod.POST)
	public ApiResponse getProductList(@RequestBody ProductListRequest plReq) {
		return categoryService.getProductList(plReq);
	}
		
}
