package com.example.ecommerceproductcatalog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter@Table(name = "categoryMaster")
public class CategoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String name;

    @OneToMany(mappedBy = "categoryMaster", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductMaster> products = new ArrayList<>();

}
