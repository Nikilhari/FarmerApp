package com.example.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vegetable")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vegetables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String farmerCode;
    private String vegetableName;
    private double vegetablePrice;

}
