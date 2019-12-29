package pe.com.producs.lenz.msproducts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Flux<Product> listar() {
        return productService.findAll().doOnNext(System.out::println);
    }

    @GetMapping(value = "/products/{id}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Product> detail(@PathVariable Long id) throws Exception {
        try {
            Thread.sleep(2000L);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return productService.findById(id);
    }

}
