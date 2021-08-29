package org.soujava;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import static org.soujava.PlayerTestDataBuilder.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {


    @Test
    public void shouldReturnErrorWhenStartIsFuture() {
        Year year = Year.now().plus(1, ChronoUnit.YEARS);
        assertThrows(IllegalArgumentException.class, () -> Player.name("Marta").start(year));
    }

    @Test
    public void shouldReturnErrorWhenStartBeforeSoccer() {
        Year year = Player.SOCCER_BORN.plus(-1, ChronoUnit.YEARS);
        assertThrows(IllegalArgumentException.class, () -> Player.name("Marta").start(year));
    }

    @Test
    public void shouldReturnErrorWhenEndBeforeSoccer() {
        Year year = Player.SOCCER_BORN.plus(-1, ChronoUnit.YEARS);
        assertThrows(IllegalArgumentException.class, () -> Player.name("Marta").start(year).end(year));
    }

    @Test
    public void shouldReturnErrorWhenThereIsInvalidPeriod() {
        Year start = Year.now().plus(1, ChronoUnit.YEARS);
        Year end = Year.now();
        assertThrows(IllegalArgumentException.class, () -> Player.name("Marta").start(start).end(end));
    }

    @Test
    public void shouldRefuseNegativeSalary() {
        CurrencyUnit usd = Monetary.getCurrency(Locale.US);
        MonetaryAmount salary = Money.of(-1, usd);
        var start = Year.now();
        var end = start.plusYears(1L);
        assertThrows(IllegalArgumentException.class, () ->
                Player.name("Marta").start(start).end(end).position(Position.FORWARD).salary(salary));
    }

    @Test
    public void shouldCreateInstance() {
        Player marta = Player.name(NAME)
                .start(START)
                .end(START.plusYears(1L))
                .position(POSITION)
                .salary(SALARY)
                .email(EMAIL);

        Assertions.assertNotNull(marta);

        Assertions.assertEquals(NAME, marta.getName());
        Assertions.assertEquals(START, marta.getStart());
        Assertions.assertEquals(POSITION, marta.getPosition());
        Assertions.assertEquals(SALARY, marta.getSalary());
        Assertions.assertEquals(EMAIL, marta.getEmail());
    }

    @Test
    public void shouldNotAllowSetWrongPeriod() {
        Year end = START.plus(-1, ChronoUnit.YEARS);
        Player marta = PlayerTestDataBuilder.martaPlayer();
        assertThrows(IllegalArgumentException.class, () -> marta.setEnd(end));
    }

    @Test
    public void shouldCreateInstanceDSL() {
        CurrencyUnit usd = Monetary.getCurrency(Locale.US);
        MonetaryAmount salary = Money.of(1_000_000, usd);
        Email email = Email.of("marta@marta.com");
        Year start = Year.now();
        Year end = start.plus(1, ChronoUnit.YEARS);

        Player marta = Player.name("Marta")
                .start(start)
                .end(end)
                .position(Position.FORWARD)
                .salary(salary).email(email);
        Assertions.assertNotNull(marta);
    }

}