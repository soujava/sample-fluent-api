package org.soujava;

import javax.money.MonetaryAmount;
import java.time.Year;

public interface FluentPlayer {

   PlayerEnd start(Year start);

    interface  PlayerEnd {
        PlayerPosition end(Year start);
    }

    interface PlayerPosition {
        PlayerSalary position(Position position);
    }

    interface PlayerSalary {
        PlayerEmail salary(MonetaryAmount salary);
    }

    interface PlayerEmail {
        Player email(Email email);

        Player build();

    }

}