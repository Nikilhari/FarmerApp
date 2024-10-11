package com.example.demo.services;

import com.example.demo.model.Farmer;
import com.example.demo.repository.FarmerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FarmerService {
    @Autowired
    private FarmerRepo farmerRepository;

    public Farmer loginFarmer(String farmerCode, String password) {
        return farmerRepository.findByFarmerCodeAndPassword(farmerCode, password);
    }

    public Farmer registerFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }
}
