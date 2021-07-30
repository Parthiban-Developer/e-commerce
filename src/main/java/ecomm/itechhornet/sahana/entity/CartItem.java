package ecomm.itechhornet.sahana.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItem extends AuditLog{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cart_item_gen")
	@SequenceGenerator(name="cart_item_gen", sequenceName="cart_item_seq", allocationSize=25, initialValue=10)
	Long id;
	
	@Column(name = "qty", nullable = false)
	int qty;
	
	@ManyToOne
	@JoinColumn(name="product_detail_id", updatable = false)
	ProductDetails productDetails;
	
	@ManyToOne
	@JoinColumn(name="image_id", updatable = false)
	Image image;
	
	@Column(name = "is_item_placed")
	boolean itemPlaced;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}
	
	public boolean isItemPlaced() {
		return itemPlaced;
	}

	public void setItemPlaced(boolean itemPlaced) {
		this.itemPlaced = itemPlaced;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", qty=" + qty + ", productDetails=" + productDetails + ", image=" + image
				+ ", itemPlaced=" + itemPlaced + "]";
	}
}
