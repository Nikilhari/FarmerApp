package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "farmer_credential")
@Data
public class Farmer {
    @Id
    private String farmerCode;

    private String name;
    private String mobile;
    private String password;
}
