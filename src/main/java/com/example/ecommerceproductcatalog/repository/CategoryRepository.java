package com.example.ecommerceproductcatalog.repository;

import com.example.ecommerceproductcatalog.model.CategoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryMaster,Integer> {
}
