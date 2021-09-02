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

    interface StyleQuantityOrder {
        DrinksOrder quantity(int quantity);
    }


    interface DrinksOrder {
        DrinksCocktailOrder softDrink(int quantity);

        DrinksSoftDrinkOrder cocktail(int quantity);

        Checkout noBeveragesThanks();
    }

    interface DrinksCocktailOrder {
        DrinksSoftDrinkOrder cocktail(int quantity);
    }

    interface DrinksSoftDrinkOrder {
        DrinksCocktailOrder softDrink(int quantity);
    }

    static SizeOrder bread(Bread bread) {
        Objects.requireNonNull(bread, "Bread is required o the order");
        return new OrderBuilder(bread);
    }
}
