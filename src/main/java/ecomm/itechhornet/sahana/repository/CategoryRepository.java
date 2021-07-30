package ecomm.itechhornet.sahana.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ecomm.itechhornet.sahana.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

	List<Category> findByParentId(Long parentid);
	List<Category> findByIdOrParentId(Long catId, Long parentid);
}
