package com.example.ecommerceproductcatalog.repository;

import com.example.ecommerceproductcatalog.model.CategoryMaster;
import com.example.ecommerceproductcatalog.model.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductMaster,Integer> {

    List<ProductMaster> findByCategoryMaster(CategoryMaster category);

    @Query("select pm from ProductMaster as pm where pm.productId=:productId")
    ProductMaster getProduct(@Param("productId") Integer productId);
}
