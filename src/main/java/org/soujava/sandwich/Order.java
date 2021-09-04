package org.soujava.sandwich;

import java.util.Objects;

public interface Order {


    interface SizeOrder {
        StyleOrder size(Size size);
    }

    interface StyleOrder {

        StyleQuantityOrder vegan();

        StyleQuantityOrder meat();
    }

    interface StyleQuantityOrder extends DrinksOrder {
        DrinksOrder quantity(int quantity);
    }


    interface DrinksOrder {
        Checkout softDrink(int quantity);

        Checkout cocktail(int quantity);

        Checkout softDrink();

        Checkout cocktail();

        Checkout noBeveragesThanks();
    }

    static SizeOrder bread(Bread bread) {
        Objects.requireNonNull(bread, "Bread is required o the order");
        return new OrderFluent(bread);
    }
}
