package com.example.ecommerceproductcatalog.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter@Setter
public class Message {
    private Boolean flag;
    private String msg;
    private Integer responseCode;

    public Message() {

    }

    public boolean isFlag() {
        return flag != null && flag;
    }

}
