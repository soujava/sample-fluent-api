package org.soujava.sandwich;

import javax.money.MonetaryAmount;

public class Sandwich {

    private final SandwichStyle style;

    private final Bread bread;

    private final Size size;

    private final MonetaryAmount price;

    Sandwich(SandwichStyle style, Bread bread, Size size, MonetaryAmount price) {
        this.style = style;
        this.bread = bread;
        this.size = size;
        this.price = price;
    }

    public SandwichStyle getStyle() {
        return style;
    }

    public Bread getBread() {
        return bread;
    }

    public Size getSize() {
        return size;
    }

    public MonetaryAmount getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "style=" + style +
                ", bread=" + bread +
                ", size=" + size +
                ", price=" + price +
                '}';
    }

}
