package com.proyecto.coffe.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.coffe.Entity.Product;
import com.proyecto.coffe.Repository.IProductRepository;

@Service
public class ProductService implements IProductService {

    private IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findProductById(id).get();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        Product productRepository.deleteProductById(id);
    }

    @Override
    public List<Product > getProductsByProductName(String productName) {
        return productRepository.findByNameContaining(productName);
    }

}

      
      
