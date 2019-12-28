package pe.com.producs.lenz.msproducts.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.producs.lenz.msproducts.model.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
