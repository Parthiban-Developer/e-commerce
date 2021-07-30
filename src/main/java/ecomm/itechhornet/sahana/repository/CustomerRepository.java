package ecomm.itechhornet.sahana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecomm.itechhornet.sahana.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Customer findByName(String name);

	Customer findByMobile(String mobile);

}
