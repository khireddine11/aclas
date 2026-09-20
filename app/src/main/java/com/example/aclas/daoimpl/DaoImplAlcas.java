package com.example.aclas.daoimpl;

import com.example.aclas.model.Aclas;

import java.util.ArrayList;

public class DaoImplAlcas {

    public ArrayList<Aclas> calculateValidIncrements(double maxWeightGrs, int basePrice) {
        ArrayList<Aclas> validPoints = new ArrayList<>();

        for (int i = 5; i <= maxWeightGrs; i += 5) {
            double weightKg = i / 1000.0;
            double calculatedPrice = weightKg * basePrice;

            if (calculatedPrice % 5 == 0) {
                validPoints.add(new Aclas(weightKg, (int) calculatedPrice));
            }
        }
        return validPoints;
    }
}

