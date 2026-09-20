package com.example.aclas.model;
import java.util.Locale;
public class Aclas {
    private double weight;
    private int mainprice;

    public Aclas(double weight, int mainprice) {
        this.weight = weight;
        this.mainprice = mainprice;
    }

    public Aclas() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMainprice() {
        return mainprice;
    }

    public void setMainprice(int mainprice) {
        this.mainprice = mainprice;
    }

    public String getFormattedWeight() {
        return String.format(Locale.US, "%.3f", this.weight);
    }

}
