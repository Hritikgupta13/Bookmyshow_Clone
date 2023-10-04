package com.example.bookmyshow.data;

import com.example.bookmyshow.model.Admin;
import com.example.bookmyshow.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {

    Boolean existsByEmail(String email);

    Admin findByEmail(String email);

}