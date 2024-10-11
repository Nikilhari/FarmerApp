package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_credential")
@Data
public class Customer {
    @Id
    private String email;

    private String name;
    private String mobile;
    private String password;
}
