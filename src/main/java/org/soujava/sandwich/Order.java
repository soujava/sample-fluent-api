package org.soujava.sandwich;

public interface Order {


    interface SizeOrder {
        StyleOrder size(Size size);
    }

    interface StyleOrder {

        StyleQuantityOrder vegan();

        StyleQuantityOrder meat();

        Checkout checkout();
    }

    interface StyleQuantityOrder {
        DrinksOrder quantity(int quantity);
    }


    interface DrinksOrder {
        DrinksQuantityOrder softDrink();

        DrinksQuantityOrder cocktail();
    }

    interface DrinksQuantityOrder {
        Checkout quantity(int quantity);
    }

    static SizeOrder order(Bread bread) {
        return null;
    }
}
