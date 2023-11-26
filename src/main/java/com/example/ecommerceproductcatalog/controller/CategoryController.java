package com.example.ecommerceproductcatalog.controller;

import com.example.ecommerceproductcatalog.dto.req.CategoryRequest;
import com.example.ecommerceproductcatalog.dto.res.Message;
import com.example.ecommerceproductcatalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "/createCategory")
    public ResponseEntity createCategory(@RequestBody CategoryRequest categoryRequest) {
        Message message = categoryService.createCategory(categoryRequest);
        return new ResponseEntity(message, HttpStatus.OK);
    }
}
