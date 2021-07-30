package ecomm.itechhornet.sahana.response;

import ecomm.itechhornet.sahana.dto.CategoryDto;

public class ProductListResponse {

	CategoryDto categoryDto;

	public ProductListResponse(CategoryDto catDto) {
		this.categoryDto = catDto;
	}

	public CategoryDto getCategoryDto() {
		return categoryDto;
	}

	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}

}
