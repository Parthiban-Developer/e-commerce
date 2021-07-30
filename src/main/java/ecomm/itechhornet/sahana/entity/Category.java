package ecomm.itechhornet.sahana.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name = "category_name", nullable = false)
	String catName;
	
	@Column(name = "display_name")
	String displayName;
	
	@Column(name = "category_image")
	String catImage;
	
	@Column(name = "parent_cat_id")
	Long parentId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private List<Product> products;
	
	public Long getId() {
		return id;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getCatImage() {
		return catImage;
	}
	public void setCatImage(String catImage) {
		this.catImage = catImage;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", catName=" + catName + ", displayName=" + displayName + ", catImage=" + catImage
				+ ", parentId=" + parentId + ", products=" + products + "]";
	}
	
	/*
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}*/
	
}
