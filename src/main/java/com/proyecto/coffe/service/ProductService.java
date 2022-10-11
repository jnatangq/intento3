package com.proyecto.coffe.service;

import java.util.List;

import com.proyecto.coffe.Entity.Product;
import com.proyecto.coffe.Repository.IProductRepository;


public class ProductService implements IProductService {

    private IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAllSortByproductName();
    }


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product );
    }

    

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductsByproductName(String productName) {
        
        return productRepository.findByProductContaining(productName);
    }

    @Override
    public Product getProductById(Long id) {
     
        return null;
    }

   
    }

  



      

