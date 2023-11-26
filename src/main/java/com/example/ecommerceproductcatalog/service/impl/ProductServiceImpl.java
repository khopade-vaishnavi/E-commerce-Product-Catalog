package com.example.ecommerceproductcatalog.service.impl;

import com.example.ecommerceproductcatalog.dto.req.ProductRequest;
import com.example.ecommerceproductcatalog.dto.req.UpdateProductRequest;
import com.example.ecommerceproductcatalog.dto.res.Message;
import com.example.ecommerceproductcatalog.model.CategoryMaster;
import com.example.ecommerceproductcatalog.model.ProductMaster;
import com.example.ecommerceproductcatalog.repository.CategoryRepository;
import com.example.ecommerceproductcatalog.repository.ProductRepository;
import com.example.ecommerceproductcatalog.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Message createProduct(ProductRequest productRequest) {
        Message message=new Message();
        CategoryMaster categoryMaster = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(() -> new EntityNotFoundException("Category not found"));
        ProductMaster productMaster = new ProductMaster();
        categoryMaster.setCategoryId(productRequest.getCategoryId());
        productMaster.setCategoryMaster(categoryMaster);
        productMaster.setName(productRequest.getName());
        productMaster.setPrice(productRequest.getPrice());
        try {
            productRepository.save(productMaster);
            message.setFlag(true);
            message.setResponseCode(200);
            message.setMsg("product add successfully");
        } catch (Exception e) {
            e.printStackTrace();
            message.setFlag(false);
            message.setResponseCode(400);
            message.setMsg("product does add successfully");
        }
        return message;
    }

    @Override
    public Message updateProduct(UpdateProductRequest updateProductRequest) {
        Message message=new Message();
        ProductMaster productMaster = productRepository.getProduct(updateProductRequest.getProductId());

        CategoryMaster categoryMaster = new CategoryMaster();
        categoryMaster.setCategoryId(updateProductRequest.getCategoryId());
        productMaster.setCategoryMaster(categoryMaster);

        productMaster.setProductId(updateProductRequest.getProductId());
        productMaster.setName(updateProductRequest.getName());
        productMaster.setPrice(updateProductRequest.getPrice());
        try {
            productRepository.save(productMaster);
            message.setFlag(true);
            message.setResponseCode(200);
            message.setMsg("product update successfully");
        } catch (Exception e) {
            e.printStackTrace();
            message.setFlag(false);
            message.setResponseCode(400);
            message.setMsg("product does not update successfully");
        }
        return message;
    }

    @Override
    public Message removeProduct(Integer productId) {
        Message message = new Message();
        try {
            ProductMaster productMaster = productRepository.findById(productId)
                    .orElseThrow(() -> new EntityNotFoundException("Product not found"));

            productRepository.delete(productMaster);

            message.setMsg("Removed product successfully");
            message.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setMsg("Failed to remove product");
            message.setFlag(false);
        }
        return message;
    }

    @Override
    public List<ProductMaster> getProductsByCategory(Integer categoryId) {
        CategoryMaster category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return productRepository.findByCategoryMaster(category);
    }
}

