package com.example.demo.repository;

import com.example.demo.model.Vegetables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VegetableRepo extends JpaRepository<Vegetables, Long> {

    @Query("SELECT v.vegetableName, AVG(v.vegetablePrice), v.imageUrl FROM Vegetables v GROUP BY v.vegetableName, v.imageUrl")
    List<Object[]> findAveragePrices();

}
