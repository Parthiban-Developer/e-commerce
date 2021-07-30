package ecomm.itechhornet.sahana.service.impl;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import ecomm.itechhornet.sahana.dto.ApiResponse;
import ecomm.itechhornet.sahana.dto.CustomerDto;
import ecomm.itechhornet.sahana.entity.Address;
import ecomm.itechhornet.sahana.entity.Customer;
import ecomm.itechhornet.sahana.repository.AddressRepository;
import ecomm.itechhornet.sahana.repository.CustomerRepository;
import ecomm.itechhornet.sahana.request.LoginRequest;
import ecomm.itechhornet.sahana.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	private static final String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

	@Override
	public ApiResponse registerUser(Customer customer) {

		ObjectMapper om = new ObjectMapper();
		CustomerDto custDto = null;
		Customer cust = null;
		
		if(customer.isRegUser()) {
			// For Registered user
			Customer existingCust = customerRepository.findByMobile(customer.getMobile());
			
			if(existingCust != null) {
				return new ApiResponse("400", "Customer is already registered with this mobile number.", null);
			}
			
			ApiResponse valiResp = validateCustomerDetails(customer);
			if(valiResp.getStatus() == "200") {
				cust = customerRepository.save(customer);
				custDto = om.convertValue(cust, CustomerDto.class);
				return new ApiResponse("200", "User registration success.", custDto);
			}
			return valiResp;
		} else {
			// For guest user
			cust = customerRepository.save(customer);
			
			custDto = om.convertValue(cust, CustomerDto.class);
			return new ApiResponse("200", "Success, guest user.", custDto);
		}		
	}
	
	// Register User Validation
	private ApiResponse validateCustomerDetails(Customer customer) {
		
		if (customer.getName() == null || customer.getName().isEmpty()) {
			return new ApiResponse("500", "Name should not be empty.", null);
		}
		
		if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
			return new ApiResponse("500", "Password should not be empty.", null);
		}
		
		if (customer.getPassword().length() < 5) {
			return new ApiResponse("500", "Password should have atleast 5 characters.", null);
		}
		
		Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(customer.getEmail());
		if(!matcher.matches()) {
			return new ApiResponse("500", "Email id is invalid.", null);
		}
		
		Pattern p = Pattern.compile("[7-9][0-9]{9}");
		Matcher m = p.matcher(customer.getMobile());
		if(!m.matches()) {
			return new ApiResponse("500", "Mobile number is invalid.", null);
		}
		
		return new ApiResponse("200", "Validation sucess!", null);
	}

	// Update User details when user checkout
	@Override
	public ApiResponse updateUser(String id, Customer customer) {
		Optional<Customer> foundCust = customerRepository.findById(Long.valueOf(id));
		ObjectMapper om = new ObjectMapper();
		CustomerDto custDto = null;
		
		if(foundCust.isEmpty()) {
			return new ApiResponse("403", "User is not found.", null);
		}
		Customer custDB = foundCust.get();
		
		custDB.setName(customer.getName());
		custDB.setRegUser(customer.isRegUser());
		custDB.setMobile(customer.getMobile());
		custDB.setEmail(customer.getEmail());
		custDB.setBillShipSame(customer.isBillShipSame());
		custDB.setSubscribed(customer.isSubscribed());
		
		if(customer.isRegUser() && customer.getPassword() != null) {
			if (customer.getPassword().length() < 5) {
				return new ApiResponse("500", "Password should have atleast 5 characters.", null);
			}
			custDB.setPassword(customer.getPassword());
		}
		
		ApiResponse validateBillAddress = validateAddress(customer.getBilladdress());
		if(validateBillAddress != null) 
			return validateBillAddress;
			
		if(custDB.getBilladdress() == null) {
			custDB.setBilladdress(customer.getBilladdress());
		} else {
			updateExistingAddress(custDB.getBilladdress().getId(), customer.getBilladdress());
		}

		
		ApiResponse validateShipAddress = validateAddress(customer.getShipaddress());
		if(!customer.isBillShipSame() && validateShipAddress != null)
			return validateShipAddress;
		
		if(custDB.getShipaddress() == null) {
			custDB.setShipaddress(customer.getShipaddress());
		} else {
			updateExistingAddress(custDB.getShipaddress().getId(), customer.getShipaddress());
		}		
		
		Customer custSave = customerRepository.save(custDB);
		custDto = om.convertValue(custSave, CustomerDto.class);
		return new ApiResponse("202", "Updated sucessfully", custDto);
	}

	// Update already existing address details for the user
	private void updateExistingAddress(Long id, Address addr) {
		Address addrDB = addressRepository.findById(id).get();
		addrDB.setAddress1(addr.getAddress1());
		addrDB.setAddress2(addr.getAddress2());
		addrDB.setCity(addr.getCity());
		addrDB.setCountry(addr.getCountry());
		addrDB.setPincode(addr.getPincode());
		addrDB.setState(addr.getState());
		addressRepository.save(addrDB);
	}
	
	//validate address
	private ApiResponse validateAddress(Address address) {
		if (address != null) {
			if (address.getAddress1() == null || address.getAddress1().isEmpty()) {
				return new ApiResponse("500", "Address should not be empty.", null);
			}
			
			if (address.getCity() == null || address.getCity().isEmpty()) {
				return new ApiResponse("500", "City should not be empty.", null);
			}
			
			if (address.getCountry() == null || address.getCountry().isEmpty()) {
				return new ApiResponse("500", "Country should not be empty.", null);
			}
			
			if (address.getState() == null || address.getState().isEmpty()) {
				return new ApiResponse("500", "State should not be empty.", null);
			}
			
			Pattern pinP = Pattern.compile("[0-9]{6}");
			Matcher pinM = pinP.matcher(address.getPincode());
			
			if(!pinM.matches()) {
				return new ApiResponse("500", "Pincode is invalid.", null);
			}
		} else {
			return new ApiResponse("500", "Address should not be empty.", null);
		}
		return null;
	}

	@Override
	public ApiResponse login(LoginRequest login) {
		ObjectMapper om = new ObjectMapper();
		
		if(login == null || login.getMobile() == null || login.getPassword() == null) {
			return new ApiResponse("500", "Invalid Username or Passowrd.", null);
		}
		
		Customer existingCust = customerRepository.findByMobile(login.getMobile());
		
		if(existingCust == null) {
			return new ApiResponse("403", "Customer is not registered.", null);
		}
		
		if(!existingCust.getPassword().equals(login.getPassword())) {
			return new ApiResponse("403", "Password doesn't match.", null);
		}
		CustomerDto custDto = om.convertValue(existingCust, CustomerDto.class);
		return new ApiResponse("200", "Login success.", custDto);
	}
}
