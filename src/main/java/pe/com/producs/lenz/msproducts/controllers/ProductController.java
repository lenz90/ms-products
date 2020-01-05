package pe.com.producs.lenz.msproducts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.producs.lenz.msproducts.model.entity.Product;
import pe.com.producs.lenz.msproducts.model.service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Flux<Product> listar() {
        return productService.findAll().doOnNext(System.out::println);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Product> detail(@PathVariable Long id) throws Exception {
        try {
            Thread.sleep(2000L);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return productService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> create(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> update(@RequestBody Product product, @PathVariable Long id) {
        return productService.findById(id).map(x->{
            x.setName(product.getName());
            x.setPrice(product.getPrice());
            return x;
        }).flatMap(productService::save);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Product> update(@PathVariable Long id) {
        return productService.delete(id);
    }


}
