package net.thumbtack.school.misc.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCar {

    @Test
    public void testCar1() {
        int volume = 270;
        String name = "Porsche";
        Car car = new Car(volume, name, 1);
        assertAll(
                () -> assertEquals(270, car.getVolume()),
                () -> assertEquals("Porsche", car.getName()),
                () -> assertEquals(1, car.getColor())
        );
    }

    @Test
    public void testCar2() {
        Car car = new Car(2);
        assertAll(
                () -> assertEquals(250, car.getVolume()),
                () -> assertEquals("BMW", car.getName()),
                () -> assertEquals(2, car.getColor())
        );
    }

    @Test
    public void testCar3() {
        Car car = new Car();
        assertAll(
                () -> assertEquals(250, car.getVolume()),
                () -> assertEquals("BMW", car.getName()),
                () -> assertEquals(5, car.getColor())
        );
    }

    @Test
    public void setVolumeAndNameAndColor() {
        Car car = new Car(150, "Nissan", 3);
        car.setVolume(180);
        car.setName("KIA");
        car.setColor(4);
        assertAll(
                () -> assertEquals(180, car.getVolume()),
                () -> assertEquals("KIA", car.getName()),
                () -> assertEquals(4, car.getColor())
        );
    }

    @Test
    public void testEqualsCar() {
        Car car1 = new Car(100, "Toyota", 2);
        Car car2 = new Car(100, "Toyota", 2);
        Car car3 = new Car(120, "BMW", 4);
        Car car4 = new Car(100, "Nissan", 5);
        assertEquals(car1, car2);
        assertNotEquals(car1, car3);
        assertNotEquals(car1, car4);
        assertNotEquals(car3, car4);
    }
}
