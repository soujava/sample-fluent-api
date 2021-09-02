package org.soujava.sandwich;

import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void shouldCreateAMeatOrderNoBeverages() {
        Checkout checkout = Order
                .bread(Bread.GLUTEN_FREE)
                .size(Size.LARGE)
                .meat()
                .quantity(2)
                .noBeveragesThanks();
    }

    @Test
    public void shouldCreateAVeganOrderNoBeverages() {
        Checkout checkout = Order.bread(Bread.GLUTEN_FREE)
                .size(Size.LARGE)
                .meat()
                .quantity(2)
                .noBeveragesThanks();
    }

    @Test
    public void shouldCreateAnOrder() {
        Checkout checkout = Order.bread(Bread.GLUTEN_FREE)
                .size(Size.LARGE)
                .meat()
                .quantity(2)
                .noBeveragesThanks();
    }
}
