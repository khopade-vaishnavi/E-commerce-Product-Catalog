package com.example.ecommerceproductcatalog.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProductRequest {
    private String name;
    private double price;
    private Integer categoryId;

}