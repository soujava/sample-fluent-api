package org.soujava.sandwich;

import javax.money.MonetaryAmount;
import java.util.Objects;

class OrderBuilder implements Order.SizeOrder, Order.StyleOrder, Order.StyleQuantityOrder, Order.DrinksOrder {

    private final PricingTables pricingTables = PricingTables.INSTANCE;

    private final Bread bread;

    private Size size;

    private Sandwich sandwich;

    private int quantity;

    private Drink drink;

    private int drinkQuantity;

    private MonetaryAmount total;

    OrderBuilder(Bread bread) {
        this.bread = bread;
    }

    @Override
    public Order.StyleOrder size(Size size) {
        Objects.requireNonNull(size, "Size is required");
        this.size = size;
        return this;
    }

    @Override
    public Order.StyleQuantityOrder vegan() {
        createSandwich(SandwichStyle.VEGAN);
        return this;
    }

    @Override
    public Order.StyleQuantityOrder meat() {
        createSandwich(SandwichStyle.MEAT);
        return this;
    }

    @Override
    public Order.DrinksOrder quantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("You must request at least one sandwich");
        }
        this.quantity = quantity;
        return this;
    }

    @Override
    public Checkout softDrink(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("You must request at least one sandwich");
        }
        this.drinkQuantity = quantity;
        this.drink = new Drink(DrinkType.SOFT_DRINK, pricingTables.getPrice(DrinkType.SOFT_DRINK));
        return checkout();
    }

    @Override
    public Checkout cocktail(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("You must request at least one sandwich");
        }
        this.drinkQuantity = quantity;
        this.drink = new Drink(DrinkType.COCKTAIL, pricingTables.getPrice(DrinkType.COCKTAIL));
        return checkout();
    }

    @Override
    public Checkout noBeveragesThanks() {
        return checkout();
    }

    private Checkout checkout() {
        MonetaryAmount sandwichTotal = sandwich.getPrice().multiply(quantity);
        MonetaryAmount drinkTotal = drink.getPrice().multiply(drinkQuantity);
        MonetaryAmount total = sandwichTotal.add(drinkTotal);
        return new Checkout(sandwich, quantity, drink, drinkQuantity, total);
    }

    private void createSandwich(SandwichStyle style) {
        MonetaryAmount breadPrice = pricingTables.getPrice(this.bread);
        MonetaryAmount sizePrice = pricingTables.getPrice(this.size);
        MonetaryAmount stylePrice = pricingTables.getPrice(SandwichStyle.VEGAN);
        MonetaryAmount total = breadPrice.add(sizePrice).add(stylePrice);
        this.sandwich = new Sandwich(style, this.bread, this.size, total);
    }
}
