package ecomm.itechhornet.sahana.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ecomm.itechhornet.sahana.entity.Color;
import ecomm.itechhornet.sahana.entity.Size;

public class CategoryDto {
	Long catId;
	String catName;
	String displyName;
	List<DataPair> childCategory = new ArrayList<>();
	double minPrice;
	double maxPrice;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	List<Color> color = new ArrayList<>();

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	List<Size> size = new ArrayList<>();

	long totalProduct;

	int totalPage;

	List<ProductDto> productDto = new ArrayList<>();

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public long getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(long totalProduct) {
		this.totalProduct = totalProduct;
	}

	public List<ProductDto> getProductDto() {
		return productDto;
	}

	public void setProductDto(List<ProductDto> productDto) {
		this.productDto = productDto;
	}

	public String getDisplyName() {
		return displyName;
	}

	public void setDisplyName(String displyName) {
		this.displyName = displyName;
	}

	public List<Color> getColor() {
		return color;
	}

	public void setColor(List<Color> color) {
		this.color = color;
	}

	public List<Size> getSize() {
		return size;
	}

	public void setSize(List<Size> size) {
		this.size = size;
	}

	public void setChildCategory(List<DataPair> childCategory) {
		this.childCategory = childCategory;
	}

	public List<DataPair> getChildCategory() {
		return childCategory;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
}
