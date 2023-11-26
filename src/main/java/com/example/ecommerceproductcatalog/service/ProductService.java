package com.example.ecommerceproductcatalog.service;

import com.example.ecommerceproductcatalog.dto.req.ProductRequest;
import com.example.ecommerceproductcatalog.dto.req.UpdateProductRequest;
import com.example.ecommerceproductcatalog.dto.res.Message;
import com.example.ecommerceproductcatalog.model.ProductMaster;

import java.util.List;

public interface ProductService {
    Message createProduct(ProductRequest productRequest);

    Message updateProduct(UpdateProductRequest updateProductRequest);

    Message removeProduct(Integer productId);

    List<ProductMaster> getProductsByCategory(Integer categoryId);
}
