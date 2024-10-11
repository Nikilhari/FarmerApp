package com.example.demo.controller;

import com.example.demo.model.Vegetables;
import com.example.demo.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    @Autowired
    private VegetableService vegetableService;

    @PostMapping("/add-vegetables")
    public ResponseEntity<String> addVegetable(@RequestBody Vegetables vegetables)
    {
        vegetableService.addVegetable(vegetables);
        return ResponseEntity.ok("Price added successfully");
    }
    @GetMapping("/")
    public ResponseEntity<Map<String, Double>> getVegetableAverages() {
        Map<String, Double> averages = vegetableService.getAveragePrices();
        return ResponseEntity.ok(averages);
    }
}
