package ecomm.itechhornet.sahana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecomm.itechhornet.sahana.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
