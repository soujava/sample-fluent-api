package org.soujava.sandwich;

public interface Order {


    interface SizeOrder {
        StyleOrder size(Size size);
    }

    interface StyleOrder {

        StyleQuantityOrder vegan();

        StyleQuantityOrder meat();
    }

    interface StyleQuantityOrder {
        DrinksOrder quantity(int quantity);
    }


    interface DrinksOrder {
        DrinksQuantityOrder softDrink();

        DrinksQuantityOrder cocktail();

        Checkout noBeveragesThanks();
    }

    interface DrinksQuantityOrder {
        Checkout quantity(int quantity);
    }

    static SizeOrder bread(Bread bread) {
        return null;
    }
}
