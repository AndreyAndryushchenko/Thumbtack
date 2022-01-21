package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDog {
    @Test
    public void testDog1() throws ColorException {
        Dog dog = new Dog(2, Color.GREEN);
        assertAll(
                () -> assertEquals(2, dog.getAge()),
                () -> assertEquals(Color.GREEN, dog.getColor())
        );
    }

    @Test
    public void testDog2() throws ColorException {
        Dog dog = new Dog(Color.BLUE);
        assertAll(
                () -> assertEquals(1, dog.getAge()),
                () -> assertEquals(Color.BLUE, dog.getColor())
        );
    }

    @Test
    public void testDog3() throws ColorException {
        Dog dog = new Dog();
        assertAll(
                () -> assertEquals(1, dog.getAge()),
                () -> assertEquals(Color.RED, dog.getColor())
        );
    }

    @Test
    public void testDog4() throws ColorException {
        Dog dog = new Dog(2, "GREEN");
        assertAll(
                () -> assertEquals(2, dog.getAge()),
                () -> assertEquals(Color.GREEN, dog.getColor())
        );
    }

    @Test
    public void testDog5() throws ColorException {
        Dog dog = new Dog("BLUE");
        assertAll(
                () -> assertEquals(1, dog.getAge()),
                () -> assertEquals(Color.BLUE, dog.getColor())
        );
    }

    @Test
    public void testSetAgeAndColor1() throws ColorException {
        Dog dog = new Dog(2, Color.GREEN);
        dog.setAge(12);
        dog.setColor(Color.RED);
        assertAll(
                () -> assertEquals(12, dog.getAge()),
                () -> assertEquals(Color.RED, dog.getColor())
        );
    }

    @Test
    public void testSetAgeAndColor2() throws ColorException {
        Dog dog = new Dog(2, Color.GREEN);
        dog.setAge(12);
        dog.setColor("RED");
        assertAll(
                () -> assertEquals(12, dog.getAge()),
                () -> assertEquals(Color.RED, dog.getColor())
        );
    }

    @Test
    public void testEquals() throws ColorException {
        Dog dog1 = new Dog(2, Color.GREEN);
        Dog dog2 = new Dog(2, "GREEN");
        Dog dog3 = new Dog(7, "RED");
        Dog dog4 = new Dog(15, Color.BLUE);
        assertEquals(dog1, dog2);
        assertNotEquals(dog2, dog3);
        assertNotEquals(dog1, dog4);
        assertNotEquals(dog3, dog4);
    }
}
