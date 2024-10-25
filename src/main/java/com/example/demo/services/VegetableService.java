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
    public Map<String, Map<String, Object>> getAveragePrices() {
        List<Object[]> avgPricesList = vegetableRepo.findAveragePrices();
        Map<String, Map<String, Object>> averagePricesWithImages = new HashMap<>();

        for (Object[] result : avgPricesList) {
            String vegetableName = (String) result[0];
            Double averagePrice = (Double) result[1];
            String imageUrl = (String) result[2]; // Assuming imageUrl is the 3rd field

            // Create a map for price and image URL
            Map<String, Object> priceAndImage = new HashMap<>();
            priceAndImage.put("averagePrice", averagePrice);
            priceAndImage.put("imageUrl", imageUrl);

            // Add the vegetable name as the key and the price/image map as the value
            averagePricesWithImages.put(vegetableName, priceAndImage);
        }
        return averagePricesWithImages;
    }



}
