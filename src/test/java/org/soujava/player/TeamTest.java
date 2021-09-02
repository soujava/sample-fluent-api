package org.soujava.player;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;
import org.soujava.player.Email;
import org.soujava.player.Player;
import org.soujava.player.Position;
import org.soujava.player.Team;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.time.Year;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TeamTest {

    @Test
    public void shouldReturnNPEWhenNameIsNull() {
        assertThrows(NullPointerException.class, () -> Team.of(null));
    }

    @Test
    public void shouldReturnErrorWhenPlayerIsNull() {
        Team bahia = Team.of("Bahia");
        assertThrows(NullPointerException.class, () -> bahia.add(null));
    }

    @Test
    public void shouldReturnErrorWhenTeamIsOutOfLimit() {
        Team bahia = Team.of("Bahia");
        CurrencyUnit usd = Monetary.getCurrency(Locale.US);
        Year start = Year.now();

        for (int index = 0; index < Team.SIZE; index++) {
            MonetaryAmount salary = Money.of(1_000_000, usd);
            Email email = Email.of(index + "email@email.com");

            Player player = Player
                    .name("Player " + index)
                    .start(start)
                    .end(start.plusYears(1L))
                    .position(Position.FORWARD)
                    .salary(salary)
                    .email(email);
            bahia.add(player);
        }

        MonetaryAmount salary = Money.of(1_000_000, usd);
        Email email = Email.of("email@email.com");
        Player player = Player.name("Marta")
                .start(start)
                .end(start.plusYears(1L))
                .position(Position.FORWARD)
                .salary(salary)
                .email(email);

        assertThrows(IllegalArgumentException.class, () -> bahia.add(player));
    }


}