package ecomm.itechhornet.sahana.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends AuditLog{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="customer_gen")
	@SequenceGenerator(name="customer_gen", sequenceName="customer_seq", allocationSize=25, initialValue=10)
	Long id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "mobile")
	String mobile;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "bill_same_as_ship")
	boolean billShipSame;
	
	@Column(name = "is_terms_accepted")
	boolean termsAccepted;
	
	@Column(name = "is_subscribed")
	boolean subscribed;
	
	@Column(name = "other_properties")
	String otherProperties;
	
	@Column(name = "is_reg_user")
	boolean regUser;
	
	@OneToOne(cascade = CascadeType.ALL)
	Address billaddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	Address shipaddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getBilladdress() {
		return billaddress;
	}

	public void setBilladdress(Address billaddress) {
		this.billaddress = billaddress;
	}

	public Address getShipaddress() {
		return shipaddress;
	}

	public void setShipaddress(Address shipaddress) {
		this.shipaddress = shipaddress;
	}

	public String getOtherProperties() {
		return otherProperties;
	}

	public void setOtherProperties(String otherProperties) {
		this.otherProperties = otherProperties;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isBillShipSame() {
		return billShipSame;
	}

	public void setBillShipSame(boolean billShipSame) {
		this.billShipSame = billShipSame;
	}

	public boolean isTermsAccepted() {
		return termsAccepted;
	}

	public void setTermsAccepted(boolean termsAccepted) {
		this.termsAccepted = termsAccepted;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public boolean isRegUser() {
		return regUser;
	}

	public void setRegUser(boolean regUser) {
		this.regUser = regUser;
	}
		
}
