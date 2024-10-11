package com.example.demo.services;

import com.example.demo.model.Vegetables;
import com.example.demo.repository.VegetableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class VegetableService {

    @Autowired
    private VegetableRepo vegetableRepo;

    public void addVegetable(Vegetables vegetables)
    {
        vegetableRepo.save(vegetables);
    }
    public Map<String, Double> getAveragePrices() {
        List<Object[]> avgPricesList = vegetableRepo.findAveragePrices();
        Map<String, Double> averagePrices = new HashMap<>();

        for (Object[] result : avgPricesList) {
            String vegetableName = (String) result[0];
            Double averagePrice = (Double) result[1];
            averagePrices.put(vegetableName, averagePrice);
        }
        return averagePrices;
    }


}
