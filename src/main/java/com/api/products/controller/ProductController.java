package com.api.products.controller;

import com.api.products.model.Product;
import com.api.products.servcie.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @PostMapping("/product")
    public void saveProduct(@RequestBody Product product){
        service.save(product);
    }

    @PutMapping("/product/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product){
        service.updateProduct(id, product);
    }


}
