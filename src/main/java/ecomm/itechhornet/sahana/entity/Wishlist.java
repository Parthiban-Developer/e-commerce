package ecomm.itechhornet.sahana.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "wishlist")
public class Wishlist extends AuditLog{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="wishlist_gen")
	@SequenceGenerator(name="wishlist_gen", sequenceName="wishlist_seq", allocationSize=25, initialValue=10)
	Long id;
	
	@OneToOne
	@JoinColumn(name="customer_id", updatable = false)
	Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<WishlistItem> wishlistItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<WishlistItem> getWishlistItems() {
		return wishlistItems;
	}

	public void setWishlistItems(List<WishlistItem> wishlistItems) {
		this.wishlistItems = wishlistItems;
	}
		
}
