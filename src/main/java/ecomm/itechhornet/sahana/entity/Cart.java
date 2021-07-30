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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart extends AuditLog{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cart_gen")
	@SequenceGenerator(name="cart_gen", sequenceName="cart_seq", allocationSize=25, initialValue=10)
	Long id;
	
	@Column(name = "shipping_charge")
	String shippingCharge;
	
	@Column(name = "other_charge")
	String otherCharges;
	
	@OneToOne
	@JoinColumn(name="customer_id", updatable = false)
	Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<CartItem> cartItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShippingCharge() {
		return shippingCharge;
	}

	public void setShippingCharge(String shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	public String getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(String otherCharges) {
		this.otherCharges = otherCharges;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", shippingCharge=" + shippingCharge + ", otherCharges=" + otherCharges
				+ ", customer=" + customer + ", cartItems=" + cartItems + "]";
	}
}
