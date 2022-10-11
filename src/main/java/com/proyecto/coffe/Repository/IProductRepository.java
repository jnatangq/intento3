package com.proyecto.coffe.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.coffe.Entity.Product;
import com.proyecto.coffe.Entity.Tipo;

public interface IProductRepository extends JpaRepository<Tipo, Long> {

    @Query("FROM Products p WHERE p.productType LIKE :tipo ")
    public List<Product> findByProductContaining(@Param("tipo") String tipo);

    @Query("FROM Products p WHERE p.productPrice <=: productPrice")
    public List<Product> findByproductPriceLessThan(@Param("productPrice") double productPrice);

    @Query("FROM Products p ORDER BY productName ASK")
    public List<Product> findAllSortByproductName();

    public Product save(Product product);


}

