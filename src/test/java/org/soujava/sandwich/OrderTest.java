package org.soujava.sandwich;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.util.Locale;
import java.util.Optional;

public class OrderTest {

    private CurrencyUnit currency;

    @BeforeEach
    public void setUp() {
        this.currency = Monetary.getCurrency(Locale.US);
    }
    //validation invalid quantity
    //validation invalid quantity drinks

    @Test
    public void shouldCreateAMeatOrderNoBeverages() {
        Checkout checkout = Order
                .bread(Bread.GLUTEN_FREE)
                .size(Size.LARGE)
                .meat()
                .quantity(2)
                .noBeveragesThanks();

        var drink = checkout.getDrink();
        Assertions.assertTrue(drink.isEmpty());
        Assertions.assertEquals(0, checkout.getDrinkQuantity());
        Sandwich sandwich = checkout.getSandwich();
        Assertions.assertEquals(Bread.GLUTEN_FREE, sandwich.getBread());
        Assertions.assertEquals(Size.LARGE, sandwich.getSize());
        Assertions.assertEquals(SandwichStyle.MEAT, sandwich.getStyle());
        Assertions.assertEquals(Money.of(25, currency), sandwich.getPrice());
        Assertions.assertEquals(sandwich.getPrice().multiply(2L), checkout.getTotal());
    }

    @Test
    public void shouldCreateAVeganOrderNoBeverages() {
        Checkout checkout = Order.bread(Bread.ITALIAN)
                .size(Size.MEDIUM)
                .meat()
                .quantity(1)
                .noBeveragesThanks();

        var drink = checkout.getDrink();
        Assertions.assertTrue(drink.isEmpty());
        Assertions.assertEquals(0, checkout.getDrinkQuantity());
        Sandwich sandwich = checkout.getSandwich();
        Assertions.assertEquals(Bread.ITALIAN, sandwich.getBread());
        Assertions.assertEquals(Size.MEDIUM, sandwich.getSize());
        Assertions.assertEquals(SandwichStyle.MEAT, sandwich.getStyle());
        Assertions.assertEquals(Money.of(19, currency), sandwich.getPrice());
        Assertions.assertEquals(sandwich.getPrice(), checkout.getTotal());
    }

    @Test
    public void shouldCreateAnOrderWithDrink() {
        Checkout checkout = Order.bread(Bread.PLAIN)
                .size(Size.SMALL)
                .meat()
                .quantity(2)
                .softDrink(2);

        var drink = checkout.getDrink();
        Assertions.assertFalse(drink.isEmpty());
        Assertions.assertEquals(2, checkout.getDrinkQuantity());
        Sandwich sandwich = checkout.getSandwich();
        Assertions.assertEquals(Bread.PLAIN, sandwich.getBread());
        Assertions.assertEquals(Size.SMALL, sandwich.getSize());
        Assertions.assertEquals(SandwichStyle.MEAT, sandwich.getStyle());
        Assertions.assertEquals(Money.of(14, currency), sandwich.getPrice());
        Assertions.assertEquals(Money.of(1, currency), drink.get().getPrice());
        Assertions.assertEquals(Money.of(30, currency), checkout.getTotal());
    }
}
