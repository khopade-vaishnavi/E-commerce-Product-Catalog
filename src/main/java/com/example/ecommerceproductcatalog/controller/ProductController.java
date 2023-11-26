package com.example.ecommerceproductcatalog.controller;

import com.example.ecommerceproductcatalog.dto.req.ProductRequest;
import com.example.ecommerceproductcatalog.dto.req.UpdateProductRequest;
import com.example.ecommerceproductcatalog.dto.res.Message;
import com.example.ecommerceproductcatalog.model.ProductMaster;
import com.example.ecommerceproductcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/createProduct")
    public ResponseEntity<ProductMaster> createProduct(@RequestBody ProductRequest productRequest) {
        Message message = productService.createProduct(productRequest);
        return new ResponseEntity(message, HttpStatus.CREATED);
    }
    @PutMapping(value = "/updateProduct")
    public ResponseEntity<ProductMaster> updateProduct(@RequestBody UpdateProductRequest updateProductRequest) {
        Message message = productService.updateProduct(updateProductRequest);
        return new ResponseEntity(message, HttpStatus.OK);
    }
    @DeleteMapping("/removeProduct/{productId}")
    public ResponseEntity<Void> removeProduct(@PathVariable Integer productId) {
        Message message=productService.removeProduct(productId);
        HttpStatus status = message.isFlag() ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST;
        return new ResponseEntity(message, status);
    }
    @GetMapping("/AllProductCategoryWise/{categoryId}")
    public ResponseEntity<List<ProductMaster>> getProductsByCategory(@PathVariable Integer categoryId) {
        List<ProductMaster> products = productService.getProductsByCategory(categoryId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}
