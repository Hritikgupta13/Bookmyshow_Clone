package com.example.bookmyshow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Admin")
public class Admin {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Admin_seq")
    @SequenceGenerator(name = "Admin_seq", sequenceName = "Admin_seq", initialValue = 1, allocationSize=1)
    private Long id;

    private String email;

    private String password;



}
