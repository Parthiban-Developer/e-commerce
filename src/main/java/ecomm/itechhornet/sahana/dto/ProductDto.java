package ecomm.itechhornet.sahana.dto;

public class ProductDto {
	Long prodId;
	String prodName;
	String displayName;
	boolean isAvailable;
	String imagePath;
	Double price;
	Double discount;
/*	List<Long> subCategory = new ArrayList<>();
	Long[] size;
	Long[] color;
*/	
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
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
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
/*
	public Long[] getSize() {
		return size;
	}
	public void setSize(Long[] size) {
		this.size = size;
	}
	public Long[] getColor() {
		return color;
	}
	public void setColor(Long[] color) {
		this.color = color;
	}
	public List<Long> getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(List<Long> subCategory) {
		this.subCategory = subCategory;
	}
*/
}
