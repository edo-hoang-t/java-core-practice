package com.edocode.oop.hw.present;

import java.util.Arrays;

public class Present {

    private static final int DEFAULT_SIZE = 5;
    private Sweet[] sweets;
    private int curId;

    {
        curId = 0;
    }

    Present() {
        sweets = new Sweet[DEFAULT_SIZE];
    }

    Present(int capacity) {
        sweets = new Sweet[capacity];
    }

    // the method filters sweets by sugar weight inclusively
    public Sweet[] filterSweetsBySugarRange(double minSugarWeight, double maxSugarWeight) {
        int matchCount = 0;
        for (Sweet sweet : sweets) {
            if (sweet != null && (sweet.getSugarWeight() >= minSugarWeight && sweet.getSugarWeight() <= maxSugarWeight)) {
                matchCount++;
            }
        }

        Sweet[] filteredSweets = new Sweet[matchCount];
        int i = 0;
        for (Sweet sweet : sweets) {
            if (sweet != null && (sweet.getSugarWeight() >= minSugarWeight && sweet.getSugarWeight() <= maxSugarWeight)) {
                filteredSweets[i++] = sweet;
            }
        }

        return filteredSweets;
    }

    // the method calculates total weight of the present
    public double calculateTotalWeight() {
        double sumWeight = 0;
        for (Sweet sweet : sweets) {
            if (sweet != null) sumWeight += sweet.getWeight();
        }
        return sumWeight;
    }

    // the method that adds sweet to the present
    public void addSweet(Sweet sweet) {
        if (sweet == null) return;

        if (sweets.length <= curId) sweets = Arrays.copyOf(sweets, sweets.length * 2);

        sweets[curId++] = sweet;
    }

    // the method returns copy of the Sweet[] array so that nobody could
// modify state of the present without addSweet() method.
// Also array shouldn’t contain null values.
    public Sweet[] getSweets() {
        return Arrays.copyOf(sweets, curId);
    }

}
