package org.soujava.sandwich;

import javax.money.MonetaryAmount;

public class Checkout {

    private final Sandwich sandwich;

    private final int quantity;

    private final Drink drink;

    private final MonetaryAmount total;

    Checkout(Sandwich sandwich, int quantity, Drink drink, MonetaryAmount total) {
        this.sandwich = sandwich;
        this.quantity = quantity;
        this.drink = drink;
        this.total = total;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public int getQuantity() {
        return quantity;
    }

    public Drink getDrink() {
        return drink;
    }

    public MonetaryAmount getTotal() {
        return total;
    }
}
