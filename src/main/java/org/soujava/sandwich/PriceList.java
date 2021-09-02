package org.soujava.sandwich;

import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;

class PriceList {

    private final Map<Size, MonetaryAmount> sizePrice;

    private final  Map<SandwichStyle, MonetaryAmount> stylePrice;

    private final  Map<DrinkType, MonetaryAmount> drinkPrice;

    PriceList() {
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
    }
}
