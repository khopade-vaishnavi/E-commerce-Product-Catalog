package com.example.ecommerceproductcatalog.service.impl;

import com.example.ecommerceproductcatalog.dto.req.CategoryRequest;
import com.example.ecommerceproductcatalog.dto.res.Message;
import com.example.ecommerceproductcatalog.model.CategoryMaster;
import com.example.ecommerceproductcatalog.repository.CategoryRepository;
import com.example.ecommerceproductcatalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Message createCategory(CategoryRequest categoryRequest) {
        Message message = new Message();
        CategoryMaster categoryMaster = new CategoryMaster();
        categoryMaster.setName(categoryRequest.getName());
        try {
            categoryRepository.save(categoryMaster);
            message.setFlag(true);
            message.setResponseCode(200);
            message.setMsg("category add successfully");
        } catch (Exception e) {
            e.printStackTrace();
            message.setFlag(false);
            message.setResponseCode(400);
            message.setMsg("category not add successfully");
        }
        return message;
    }
}
