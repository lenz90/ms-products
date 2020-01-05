package pe.com.producs.lenz.msproducts.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.producs.lenz.msproducts.model.entity.Product;
import pe.com.producs.lenz.msproducts.model.repositories.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public Flux<Product> findAll() {
        return Flux.fromIterable(productoRepository.findAll());
    }


    @Override
    @Transactional(readOnly = true)
    public Mono<Product> findById(Long id) {
        return Mono.justOrEmpty(productoRepository.findById(id));
    }

    @Override
    @Transactional
    public Mono<Product> save(Product product) {
        return Mono.justOrEmpty(Optional.ofNullable(productoRepository.save(product)));
    }

    @Override
    @Transactional
    public Mono<Product> delete(Long id) {
        return Mono.justOrEmpty(productoRepository.findById(id).map(x -> {
            productoRepository.deleteById(x.getId());
            return x;
        }));
    }
}
