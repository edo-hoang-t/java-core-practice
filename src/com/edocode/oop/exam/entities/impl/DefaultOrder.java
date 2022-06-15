package com.edocode.oop.exam.entities.impl;

import com.edocode.oop.exam.entities.Order;
import com.edocode.oop.exam.entities.Product;

import java.util.Arrays;

public class DefaultOrder implements Order {

    private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

    private String creditCardNumber;
    private Product[] products;
    private int customerId;

    @Override
    public boolean isCreditCardNumberValid(String userInput) {
        return userInput.toCharArray().length == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER &&
                !userInput.contains(" ") && Long.parseLong(userInput) > 0;
    }

    @Override
    public void setCreditCardNumber(String userInput) {
        if (userInput == null) {
            return;
        }
        this.creditCardNumber = userInput;
    }

    @Override
    public void setProducts(Product[] products) {
        this.products = products;
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public int getCustomerId() {
        return this.customerId;
    }

    @Override
    public String toString() {
        return "Order: customer id - " + this.customerId + "\t" +
                "credit card number - " + this.creditCardNumber + "\t" +
                "products - " + Arrays.toString(this.products);
    }
}
