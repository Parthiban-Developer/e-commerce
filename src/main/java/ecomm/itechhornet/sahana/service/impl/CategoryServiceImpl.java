package ecomm.itechhornet.sahana.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomm.itechhornet.sahana.dto.ApiResponse;
import ecomm.itechhornet.sahana.dto.CategoryDto;
import ecomm.itechhornet.sahana.dto.DataPair;
import ecomm.itechhornet.sahana.dto.ProductDto;
import ecomm.itechhornet.sahana.entity.Category;
import ecomm.itechhornet.sahana.entity.Color;
import ecomm.itechhornet.sahana.entity.Image;
import ecomm.itechhornet.sahana.entity.Product;
import ecomm.itechhornet.sahana.entity.ProductDetails;
import ecomm.itechhornet.sahana.entity.Size;
import ecomm.itechhornet.sahana.repository.CategoryRepository;
import ecomm.itechhornet.sahana.request.ProductListRequest;
import ecomm.itechhornet.sahana.response.ProductListResponse;
import ecomm.itechhornet.sahana.service.CategoryService;

@Component
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	ProductListRequest plReq = null;
	Set<Double> maxPriceList = new HashSet<>();

	private List<Size> size;

	private List<Size> collect;

	@Override
	public ApiResponse getProductList(ProductListRequest plReq) {
		this.plReq = plReq;
		long categoryId = plReq.getCategoryId();
		List<Category> catListObj = categoryRepository.findByIdOrParentId(categoryId, categoryId);
		if (catListObj.size() > 0) {

			CategoryDto categoryDto = new CategoryDto();

			for (Category catObj : catListObj) {
				// primary category details
				if (catObj.getId() == categoryId) {
					setPrimaryCatDetails(categoryDto, catObj);
				} else {
					// sub category details
					List<DataPair> childCategory = categoryDto.getChildCategory();
					childCategory.add(new DataPair(catObj.getId(), catObj.getDisplayName()));
					categoryDto.setChildCategory(childCategory);
				}

				List<Product> products = catObj.getProducts();
				// product & product details
				if (plReq.getSubCategory().length > 0) {
					for (Long scid : plReq.getSubCategory()) {
						// filter selected category products alone
						if (catObj.getId() == scid) {
							setProductList(categoryDto, products);
						}
					}
				} else {
					setProductList(categoryDto, products);
				}

			}

			List<Size> sortedSize = new ArrayList<>();
			List<Color> sortedColor = new ArrayList<>();
			
			sortedSize = categoryDto.getSize().stream()
					.collect(Collectors.toSet()).stream()
					.sorted(Comparator.comparing(Size::getSize))
					.collect(Collectors.toList());
			sortedColor = categoryDto.getColor().stream()
					.collect(Collectors.toSet()).stream()
					.sorted(Comparator.comparing(Color::getId))
					.collect(Collectors.toList());
			categoryDto.setSize(sortedSize);
			categoryDto.setColor(sortedColor);

			if (maxPriceList.size() > 0)
				categoryDto.setMaxPrice(maxPriceList.stream().max(Double::compare).get());

			return new ApiResponse("200", "Success", new ProductListResponse(categoryDto));
		}

		return new ApiResponse("404", "Failure", "not found");
	}

	/* Set required product details in Category */
	private void setProductList(CategoryDto categoryDto, List<Product> products) {
		Set<Size> sizeObj = new HashSet<>();
		Set<Color> colorObj = new HashSet<>();
		boolean addProduct = true;

		for (Product pdt : products) {
			ProductDto productDto = new ProductDto();
			productDto.setAvailable(pdt.isAvailable());
			productDto.setDiscount(pdt.getDiscount());
			productDto.setDisplayName(pdt.getDisplayName());
			productDto.setProdId(pdt.getId());
			productDto.setProdName(pdt.getProdName());

			// Iterate image to get product image
			List<Image> images = pdt.getImages();
			Optional<Image> defImg = images.stream().min(Comparator.comparing(Image::getPriority));
			if (defImg.isPresent()) {
				productDto.setImagePath(defImg.get().getImgPath());
			}

			List<ProductDetails> productDetails = pdt.getProductDetails();
			// Iterate Product details to get default price
			Iterator<ProductDetails> prodDtlsItr = productDetails.iterator();

			while (prodDtlsItr.hasNext()) {
				ProductDetails prodDtls = prodDtlsItr.next();

				if (prodDtls != null && prodDtls.isDefault()) {
					// last default price would be assigned
					productDto.setPrice(prodDtls.getPrice());
				}
				sizeObj.add(prodDtls.getSize());
				colorObj.add(prodDtls.getColor());
				// Get max price for range
				if (productDetails.size() > 0)
					maxPriceList.add(productDetails.stream().max(Comparator.comparing(ProductDetails::getPrice)).get()
							.getPrice());

				// size filter
				addProduct = filterBySize(prodDtls);

				// color filter
				addProduct = filterByColor(prodDtls, addProduct);

				// min & max price filter
				addProduct = filterByPrice(prodDtls, addProduct);
			}
			if (productDto.getPrice() == null && productDetails.size() > 0) {
				productDto.setPrice(productDetails.get(0).getPrice());
			}

			if (addProduct) {
				categoryDto.getProductDto().add(productDto);
			}
			// productDetails.stream().max(Comparator.comparing(ProductDetails::getPrice)).get().getPrice()
			categoryDto.getSize().addAll(sizeObj);
			categoryDto.getColor().addAll(colorObj);
		}
	}

	/* Filter by price */
	private boolean filterByPrice(ProductDetails prodDtls, boolean addProduct) {
		if (addProduct && (plReq.getMinPrice() > 0 || plReq.getMaxPrice() > 0)) {
			if (plReq.getMinPrice() < prodDtls.getPrice() && plReq.getMaxPrice() > prodDtls.getPrice()) {
				addProduct = true;
			} else {
				addProduct = false;
			}
		}
		return addProduct;
	}

	/* Filter by size */
	private boolean filterBySize(ProductDetails prodDtls) {
		boolean addProduct = true;
		if (plReq.getSize().length > 0) {
			for (Long size : plReq.getSize()) {
				if (size == prodDtls.getSize().getId()) {
					addProduct = true;
					break;
				} else {
					addProduct = false;
				}
			}
		}
		return addProduct;
	}

	/* Filter by color */
	private boolean filterByColor(ProductDetails prodDtls, boolean addProduct) {
		if (addProduct && plReq.getColor().length > 0) {
			for (Long color : plReq.getColor()) {
				if (color == prodDtls.getColor().getId()) {
					addProduct = true;
					break;
				} else {
					addProduct = false;
				}
			}
		}
		return addProduct;
	}

	/* Category Primary Details to set */
	private void setPrimaryCatDetails(CategoryDto categoryDto, Category catObj) {
		categoryDto.setCatId(catObj.getId());
		categoryDto.setCatName(catObj.getCatName());
		categoryDto.setDisplyName(catObj.getDisplayName());
	}
}
