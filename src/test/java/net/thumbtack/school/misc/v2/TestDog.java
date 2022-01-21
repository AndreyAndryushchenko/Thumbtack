package net.thumbtack.school.misc.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDog {
    @Test
    public void testDog1() {
        Dog dog = new Dog(2, 5);
        assertAll(
                () -> assertEquals(2, dog.getAge()),
                () -> assertEquals(5, dog.getColor())
        );
    }

    @Test
    public void testDog2() {
        Dog dog = new Dog(3);
        assertAll(
                () -> assertEquals(1, dog.getAge()),
                () -> assertEquals(3, dog.getColor())
        );
    }

    @Test
    public void testDog3() {
        Dog dog = new Dog();
        assertAll(
                () -> assertEquals(1, dog.getAge()),
                () -> assertEquals(1, dog.getColor())
        );
    }

    @Test
    public void testSetAgeAndColor() {
        Dog dog = new Dog(2, 5);
        dog.setAge(12);
        dog.setColor(7);
        assertAll(
                () -> assertEquals(12, dog.getAge()),
                () -> assertEquals(7, dog.getColor())
        );
    }

    @Test
    public void testEquals() {
        Dog dog1 = new Dog(2, 5);
        Dog dog2 = new Dog(2, 5);
        Dog dog3 = new Dog(7, 3);
        Dog dog4 = new Dog(15, 9);
        assertEquals(dog1, dog2);
        assertNotEquals(dog2, dog3);
        assertNotEquals(dog1, dog4);
        assertNotEquals(dog3, dog4);
    }
}
