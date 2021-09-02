package org.soujava.sandwich;

import javax.money.MonetaryAmount;

public class Sandwich {

    private final SandwichStyle style;

    private final Bread bread;

    private final MonetaryAmount price;

    Sandwich(SandwichStyle style, Bread bread, MonetaryAmount price) {
        this.style = style;
        this.bread = bread;
        this.price = price;
    }

    public SandwichStyle getStyle() {
        return style;
    }

    public Bread getBread() {
        return bread;
    }

    public MonetaryAmount getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "style=" + style +
                ", bread=" + bread +
                ", price=" + price +
                '}';
    }
}
