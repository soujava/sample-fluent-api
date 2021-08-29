package org.soujava;

import javax.money.MonetaryAmount;
import java.time.Year;
import java.util.Objects;

public class PlayerDSL implements FluentPlayer,
        FluentPlayer.PlayerEnd, FluentPlayer.PlayerEmail, FluentPlayer.PlayerPosition,
        FluentPlayer.PlayerSalary {

    static final Year SOCCER_BORN = Year.of(1863);

    PlayerDSL(String name) {
        this.name = name;
    }

    private String name;

    private Year start;

    private Year end;

    private Email email;

    private Position position;

    private MonetaryAmount salary;


    @Override
    public PlayerEnd start(Year start) {
        return null;
    }

    @Override
    public PlayerPosition end(Year start) {
        return null;
    }

    @Override
    public PlayerSalary position(Position position) {
        return null;
    }

    @Override
    public PlayerEmail salary(MonetaryAmount salary) {
        return null;
    }

    @Override
    public Player email(Email email) {
        return null;
    }

    @Override
    public Player build() {
        return null;
    }
}