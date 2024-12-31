package com.api.products.service;

import com.api.products.model.Product;
import com.api.products.repo.ProductRepo;
import com.api.products.servcie.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private ProductService productService;

    @Test
    public void findAll(){
        //Arrange
        Product product1 = Product.builder().name("Item11").price(100).build();
        Product product2 = Product.builder().name("Item22").price(200).build();

        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(product1);
        expectedProductList.add(product2);

        Mockito.when(productRepo.findAll()).thenReturn(expectedProductList);


        //Act
        List<Product> actualProductList = productService.getAllProducts();

        //
        Assertions.assertEquals(expectedProductList, actualProductList);
    }

    @Test
    public void deleteProductById(){
        //Arrange
        //Act
        //Assert
        Assertions.assertAll(() -> productService.deleteProductById(1));
    }

}
