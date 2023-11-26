package com.example.ecommerceproductcatalog.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UpdateProductRequest {
    private Integer productId;
    private String name;
    private double price;
    private Integer categoryId;
}
