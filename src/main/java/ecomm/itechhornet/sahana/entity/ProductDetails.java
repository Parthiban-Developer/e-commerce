package ecomm.itechhornet.sahana.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "product_details")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name = "pd_name")
	String pd_name;
	
	@Column(name = "avail_qty")
	int availQty;
	
	@Column(name = "price")
	double price;
	
	@Column(name = "is_default")
	boolean isDefault;
	
	@Column(name = "is_avail")
	boolean isAvailable;

	@Column(name = "discount")
	int discount;
	
	//@NotNull
	//@ManyToOne(cascade = CascadeType.ALL)
	//private Product product;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	private Color color;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	private Size size;
	
	public Long getId() {
		return id;
	}

	public int getAvailQty() {
		return availQty;
	}

	public void setAvailQty(int availQty) {
		this.availQty = availQty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
/*
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
*/
	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getPd_name() {
		return pd_name;
	}

	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}

	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", name=" + pd_name + ", availQty=" + availQty + ", price=" + price
				+ ", isDefault=" + isDefault + ", isAvailable=" + isAvailable + ", discount=" + discount + ", color="
				+ color + ", size=" + size + "]";
	}
	
}
