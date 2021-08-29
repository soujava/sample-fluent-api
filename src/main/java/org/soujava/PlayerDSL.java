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
        Objects.requireNonNull(start, "start is required");
        if (Year.now().isBefore(start)) {
            throw new IllegalArgumentException("you cannot start in the future");
        }
        if (SOCCER_BORN.isAfter(start)) {
            throw new IllegalArgumentException("Soccer was not born on this time");
        }
        this.start = start;
        return this;
    }

    @Override
    public PlayerPosition end(Year end) {
        Objects.requireNonNull(end, "end is required");

        if (start != null && start.isAfter(end)) {
            throw new IllegalArgumentException("the last year of a player must be equal or higher than the start.");
        }

        if (SOCCER_BORN.isAfter(end)) {
            throw new IllegalArgumentException("Soccer was not born on this time");
        }
        this.end = end;
        return this;
    }

    @Override
    public PlayerSalary position(Position position) {
        Objects.requireNonNull(position, "position is required");
        this.position = position;
        return this;
    }

    @Override
    public PlayerEmail salary(MonetaryAmount salary) {
        Objects.requireNonNull(salary, "salary is required");
        if (salary.isNegativeOrZero()) {
            throw new IllegalArgumentException("A player needs to earn money to play; otherwise, it is illegal.");
        }
        this.salary = salary;
        return this;
    }

    @Override
    public Player email(Email email) {
        this.email = Objects.requireNonNull(email, "email is required");
        return null;
    }

    @Override
    public Player build() {
        return null;
    }
}