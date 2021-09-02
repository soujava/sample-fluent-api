package org.soujava.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.soujava.player.Email;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmailTest {


    @Test
    public void shouldReturnErrorWhenIsNull() {
        Assertions.assertThrows(NullPointerException.class,  () -> Email.of(null));
    }

    @Test
    public void ShouldReturnErrorWhenIsInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Email.of("invalid.email"));
    }

    @Test
    public void shouldCreateEmailInstance() {
        assertNotNull(Email.of("email@email.com"));
        assertNotNull(Email.of("email.test@email.com"));
        assertNotNull(Email.of("email.test@gmail.com.br"));
        Email email = Email.of("gmail@gmail.com");
        assertNotNull(email);
        Assertions.assertEquals("gmail@gmail.com", email.get());
    }
}