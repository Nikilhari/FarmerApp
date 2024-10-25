package com.example.demo.controller;

import com.example.demo.model.Farmer;
import com.example.demo.services.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

@RequestMapping("/farmer")
public class FarmerController {
    @Autowired
    private FarmerService farmerService;

    @PostMapping("/register")
    public Farmer addFarmer(@RequestBody Farmer farmer)
    {
        return farmerService.registerFarmer(farmer);
    }

    @PostMapping("/login")
    public ResponseEntity<String> verifyFarmer(@RequestBody Farmer farmer)
    {
        if(farmerService.loginFarmer(farmer.getFarmerCode(), farmer.getPassword())!=null)
        {
                return ResponseEntity.ok("Success");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("failed");
        }
    }
}
