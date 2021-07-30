package ecomm.itechhornet.sahana.request;

public class ProductListRequest {
	long categoryId;
	Long[] subCategory;
	int minPrice;
	int maxPrice;
	Long[] color;
	Long[] size;
	int page = 0;
	int pageSize = 2;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public Long[] getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(Long[] subCategory) {
		this.subCategory = subCategory;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Long[] getColor() {
		return color;
	}
	public void setColor(Long[] color) {
		this.color = color;
	}
	public Long[] getSize() {
		return size;
	}
	public void setSize(Long[] size) {
		this.size = size;
	}
}
