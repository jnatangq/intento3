package com.proyecto.coffe.service;



import java.util.List;

import com.proyecto.coffe.Entity.Product;

public interface IProductService {

    List<Product> getAllProducts();

    List<Product> getProductsByproductName(String productName);

    Product saveProduct(Product product);

    Product getProductById(Long id);

    Product updateProduct(Product Product);
    

    void deleteProductById(Long id);

}
