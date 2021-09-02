package org.soujava.player;

import org.javamoney.moneta.Money;
import org.soujava.player.Email;
import org.soujava.player.Player;
import org.soujava.player.Position;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.time.Year;
import java.util.Locale;

public class PlayerTestDataBuilder {

    public static final CurrencyUnit USD = Monetary.getCurrency(Locale.US);

    public static final MonetaryAmount SALARY = Money.of(1_000_000, USD);

    public static final Email EMAIL = Email.of("marta@marta.com");

    public static final Year START = Year.now();

    public static final String NAME = "Marta";

    public static final Position POSITION = Position.FORWARD;

    public static Player martaPlayer() {
        return Player
                .name(NAME)
                .start(START)
                .end(START.plusYears(1L))
                .position(POSITION)
                .salary(SALARY)
                .email(EMAIL);
    }
}