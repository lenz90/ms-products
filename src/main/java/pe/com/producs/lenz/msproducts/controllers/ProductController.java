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
    public  @ResponseBody
    Flux<Product> listar() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Mono<Product> detail(@PathVariable Long id) {
        return productService.findById(id);
    }

}
