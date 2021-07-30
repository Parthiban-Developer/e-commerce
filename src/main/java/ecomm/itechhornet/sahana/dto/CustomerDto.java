package ecomm.itechhornet.sahana.dto;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ecomm.itechhornet.sahana.entity.Address;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto{

	Long id;
	
	String name;
	
	String mobile;
	
	String email;
	
	boolean billShipSame;
	
	boolean subscribed;
	
	String otherProperties;
	
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
