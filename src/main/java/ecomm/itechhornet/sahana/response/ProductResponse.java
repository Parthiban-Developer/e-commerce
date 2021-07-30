package ecomm.itechhornet.sahana.response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ecomm.itechhornet.sahana.entity.Color;
import ecomm.itechhornet.sahana.entity.Image;
import ecomm.itechhornet.sahana.entity.ProductDetails;
import ecomm.itechhornet.sahana.entity.Size;

public class ProductResponse {

	Long id;
	
	String prodName;
	
	String displayName;
	
	String prodDesc;
	
	String otherProp;
	
	// Y - Yes, N - No, D - Deprecated
	boolean isAvailable;
	
	Double discount;
	
	private List<ProductDetails> productDetails;
	
	private List<Image> images;
	
	Set<Color> color = new HashSet<>();
	
	Set<Size> size = new HashSet<>();

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getOtherProp() {
		return otherProp;
	}

	public void setOtherProp(String otherProp) {
		this.otherProp = otherProp;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Set<Color> getColor() {
		return color;
	}

	public void setColor(Set<Color> color) {
		this.color = color;
	}

	public Set<Size> getSize() {
		return size;
	}

	public void setSize(Set<Size> size) {
		this.size = size;
	}

	
		
}
