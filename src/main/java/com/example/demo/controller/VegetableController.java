package com.example.demo.controller;

import com.example.demo.model.Vegetables;
import com.example.demo.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
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
    public ResponseEntity<Map<String, Map<String, Object>>> getVegetableAverages() {
        Map<String, Map<String, Object>> averages = vegetableService.getAveragePrices();
        return ResponseEntity.ok(averages);
    }
}
