package com.example.bookmyshow.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", initialValue = 1, allocationSize=1)
    private Long id;

    private String name;

    private String email;

    private String password;

//    public Customer(String customerEmail) {
//        this.email=customerEmail;
//    }

    public enum LoginStatus {
        INVALID_USER, LOGIN_SUCCESSFULL, CUSTOMER_SAVED, CUSTOMER_ALREADY_EXIST
    }
}