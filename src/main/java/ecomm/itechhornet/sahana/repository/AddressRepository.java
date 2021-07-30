package ecomm.itechhornet.sahana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecomm.itechhornet.sahana.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
