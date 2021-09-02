package org.soujava.sandwich;

import javax.money.MonetaryAmount;

public class Sandwich {

    private final String name;

    private final MonetaryAmount price;

    Sandwich(String name, MonetaryAmount price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public MonetaryAmount getPrice() {
        return price;
    }
}
