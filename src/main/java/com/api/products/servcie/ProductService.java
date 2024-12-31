package com.api.products.servcie;

import com.api.products.model.Product;
import com.api.products.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Product save(Product product){
        return save(product);
    }

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductById(int id){
        return repo.findById(id).orElse(null);
    }

    public Product updateProduct(int id, Product product){
//        Product currentProduct = repo.findById(id).orElse(null);
//        currentProduct.setName(product.getName());
//        currentProduct.setPrice(product.getPrice());
//        currentProduct.setId(id);

        product.setId(id);

       return repo.save(product);
    }

    public void deleteProductById(int id){
        repo.deleteById(id);
    }

}
