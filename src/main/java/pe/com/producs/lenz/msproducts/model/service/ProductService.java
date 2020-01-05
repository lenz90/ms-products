package pe.com.producs.lenz.msproducts.model.service;


import pe.com.producs.lenz.msproducts.model.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> findAll();
    Mono<Product> findById(Long id);

    Mono<Product> save(Product product);

    Mono<Product> delete(Long id);


}
