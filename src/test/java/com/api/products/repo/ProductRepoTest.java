package com.api.products.repo;

import com.api.products.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
public class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;

    @BeforeEach
    public void cleanUp(){
        productRepo.deleteAll();
    }

    @Test
    public void saveProductTest(){
        //Arrange
        Product expectedProduct = Product.builder().name("Item1").price(100).build();

        //Act
        Product actualProduct = productRepo.save(expectedProduct);

        //Assert
//        Assertions.assertNotNull(actualProduct);
        Assertions.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void findAllProductTest(){
        //Arrange
        Product product1 = Product.builder().name("Item11").price(100).build();
        Product product2 = Product.builder().name("Item22").price(200).build();

        productRepo.save(product1);
        productRepo.save(product2);
        //Act
        List<Product> productList = productRepo.findAll();

        //Assert
        Assertions.assertEquals(2,  productList.size());
    }

    @Test
    public void updateProductTest(){
        //Arrange
        Product product1 = Product.builder().name("Item1").price(100).build();
        productRepo.save(product1);
        //Act
        Product expectedProduct = productRepo.findById(product1.getId()).orElse(null);
        expectedProduct.setName("test");

        Product actualProduct = productRepo.save(expectedProduct);

        //Assert
        Assertions.assertEquals(expectedProduct.getName(), actualProduct.getName());
    }
}
