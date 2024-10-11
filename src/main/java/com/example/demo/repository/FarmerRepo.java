package com.example.demo.repository;

import com.example.demo.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FarmerRepo extends JpaRepository<Farmer, Long> {
    Farmer findByFarmerCodeAndPassword(String farmerCode, String password);
}
