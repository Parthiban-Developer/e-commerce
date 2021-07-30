package ecomm.itechhornet.sahana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecomm.itechhornet.sahana.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{

}
