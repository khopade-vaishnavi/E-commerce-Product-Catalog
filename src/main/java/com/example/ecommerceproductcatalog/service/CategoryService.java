package com.example.ecommerceproductcatalog.service;

import com.example.ecommerceproductcatalog.dto.req.CategoryRequest;
import com.example.ecommerceproductcatalog.dto.res.Message;

public interface CategoryService {
    Message createCategory(CategoryRequest categoryRequest);
}
