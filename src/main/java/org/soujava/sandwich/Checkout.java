package org.soujava.sandwich;

import javax.money.MonetaryAmount;
import java.util.Optional;

public class Checkout {

    private final Sandwich sandwich;

    private final int quantity;

    private final Drink drink;

    private final int drinkQuantity;

    private final MonetaryAmount total;

    Checkout(Sandwich sandwich, int quantity, Drink drink, int drinkQuantity, MonetaryAmount total) {
        this.sandwich = sandwich;
        this.quantity = quantity;
        this.drink = drink;
        this.drinkQuantity = drinkQuantity;
        this.total = total;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public int getQuantity() {
        return quantity;
    }

    public Optional<Drink> getDrink() {
        return Optional.ofNullable(drink);
    }

    public MonetaryAmount getTotal() {
        return total;
    }

    public int getDrinkQuantity() {
        return drinkQuantity;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "sandwich=" + sandwich +
                ", quantity=" + quantity +
                ", drink=" + drink +
                ", total=" + total +
                '}';
    }
}
