package com.example.bookmyshow.dto;

import com.example.bookmyshow.model.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    private Long id;

    private String name;

    public CustomerDTO (Customer customer){
        this.id = customer.getId();
        this.name = customer.getName();
    }

}
