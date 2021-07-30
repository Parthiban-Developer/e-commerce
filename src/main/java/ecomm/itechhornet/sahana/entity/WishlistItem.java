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
@Table(name = "wishlist_item")
public class WishlistItem extends AuditLog{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="wishlist_item_gen")
	@SequenceGenerator(name="wishlist_item_gen", sequenceName="wishlist_item_seq", allocationSize=25, initialValue=10)
	Long id;
	
	@ManyToOne
	@JoinColumn(name="product_detail_id", updatable = false)
	ProductDetails productDetails;
	
	@ManyToOne
	@JoinColumn(name="image_id", updatable = false)
	Image image;
	
	@Column(name = "is_added_to_cart")
	boolean addedToCart;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public boolean isAddedToCart() {
		return addedToCart;
	}

	public void setAddedToCart(boolean addedToCart) {
		this.addedToCart = addedToCart;
	}
}
