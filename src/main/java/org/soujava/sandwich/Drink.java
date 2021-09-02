package org.soujava.sandwich;

import javax.money.MonetaryAmount;

public class Drink {

    private final DrinkType type;

    private final MonetaryAmount price;

    Drink(DrinkType type, MonetaryAmount price) {
        this.type = type;
        this.price = price;
    }

    public DrinkType getType() {
        return type;
    }

    public MonetaryAmount getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "type=" + type +
                ", price=" + price +
                '}';
    }
}
