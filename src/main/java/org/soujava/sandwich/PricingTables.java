package org.soujava.sandwich;

import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;

import static java.util.Optional.ofNullable;

enum PricingTables {

    INSTANCE;

    private final Map<Size, MonetaryAmount> sizePrice;

    private final  Map<SandwichStyle, MonetaryAmount> stylePrice;

    private final  Map<DrinkType, MonetaryAmount> drinkPrice;

    private final  Map<Bread, MonetaryAmount> breadPrice;

    PricingTables() {
        CurrencyUnit currency = Monetary.getCurrency(Locale.US);

        this.sizePrice = new EnumMap<>(Size.class);
        this.sizePrice.put(Size.SMALL, Money.of(1, currency));
        this.sizePrice.put(Size.MEDIUM, Money.of(5, currency));
        this.sizePrice.put(Size.LARGE, Money.of(10, currency));

        this.stylePrice = new EnumMap<>(SandwichStyle.class);
        this.stylePrice.put(SandwichStyle.MEAT, Money.of(10, currency));
        this.stylePrice.put(SandwichStyle.VEGAN, Money.of(12, currency));

        this.drinkPrice = new EnumMap<>(DrinkType.class);
        this.drinkPrice.put(DrinkType.SOFT_DRINK, Money.of(1, currency));
        this.drinkPrice.put(DrinkType.COCKTAIL, Money.of(6, currency));

        this.breadPrice = new EnumMap<>(Bread.class);
        this.breadPrice.put(Bread.PLAIN, Money.of(1, currency));
        this.breadPrice.put(Bread.ITALIAN, Money.of(2, currency));
        this.breadPrice.put(Bread.GLUTEN_FREE, Money.of(3, currency));
    }

    MonetaryAmount getPrice(DrinkType type) {
        return ofNullable(this.drinkPrice.get(type))
                .orElseThrow(() -> new IllegalArgumentException("There is not price to the drink " + type));
    }

    MonetaryAmount getPrice(SandwichStyle style) {
        return ofNullable(this.stylePrice.get(style))
                .orElseThrow(() -> new IllegalArgumentException("There is not price to the sandwich style " + style));
    }

    MonetaryAmount getPrice(Size size) {
        return ofNullable(this.sizePrice.get(size))
                .orElseThrow(() -> new IllegalArgumentException("There is not price to the size " + size));
    }
}
