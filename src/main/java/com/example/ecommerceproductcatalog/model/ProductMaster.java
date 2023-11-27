package com.example.ecommerceproductcatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@Entity
@Table(name = "productMaster")
public class ProductMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private CategoryMaster categoryMaster;

}
