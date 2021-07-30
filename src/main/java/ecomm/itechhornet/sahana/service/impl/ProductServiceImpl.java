package ecomm.itechhornet.sahana.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import ecomm.itechhornet.sahana.dto.ApiResponse;
import ecomm.itechhornet.sahana.entity.Color;
import ecomm.itechhornet.sahana.entity.Product;
import ecomm.itechhornet.sahana.entity.Size;
import ecomm.itechhornet.sahana.repository.ProductRepository;
import ecomm.itechhornet.sahana.response.ProductResponse;
import ecomm.itechhornet.sahana.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public ApiResponse getProductById(int id) {

		Optional<Product> prod = productRepository.findById((long) id);
		if (!prod.isPresent()) {
			return new ApiResponse("404", "Failure", "Product is not found.");
		}
		
		Product p = prod.get();
		ProductResponse pr = new ProductResponse();

		pr.setId(p.getId());
		pr.setProdName(p.getProdName());
		pr.setDisplayName(p.getDisplayName());
		pr.setProdDesc(p.getProdDesc());
		pr.setOtherProp(p.getOtherProp());
		pr.setAvailable(p.isAvailable());
		pr.setDiscount(p.getDiscount());
		pr.setProductDetails(p.getProductDetails());
		pr.setImages(p.getImages());
		pr.setColor(getColorForPdt(p));
		pr.setSize(getSizeForPdt(p));

		// prodEntity
		return new ApiResponse("200", "Success", pr);
	}

	// Get list of color related to the requested product
	private Set<Color> getColorForPdt(Product p) {
		Set<Color> clr = new HashSet<>();

		if (p.getProductDetails() != null) {
			p.getProductDetails().forEach(pd -> {
				clr.add(pd.getColor());
			});
		}
		return clr;
	}

	// Get list of color related to the requested product
	private Set<Size> getSizeForPdt(Product p) {
		Set<Size> size = new HashSet<>();

		if (p.getProductDetails() != null) {
			p.getProductDetails().forEach(pd -> {
				size.add(pd.getSize());
			});
		}
		return size;
	}
}
