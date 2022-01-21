package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCar {

    @Test
    public void testCar1() throws ColorException {
        int volume = 270;
        String name = "Porsche";
        Car car = new Car(volume, name, Color.BLUE);
        assertAll(
                () -> assertEquals(270, car.getVolume()),
                () -> assertEquals("Porsche", car.getName()),
                () -> assertEquals(Color.BLUE, car.getColor())
        );
    }

    @Test
    public void testCar2() throws ColorException {
        Car car = new Car(Color.GREEN);
        assertAll(
                () -> assertEquals(250, car.getVolume()),
                () -> assertEquals("BMW", car.getName()),
                () -> assertEquals(Color.GREEN, car.getColor())
        );
    }

    @Test
    public void testCar3() throws ColorException {
        Car car = new Car();
        assertAll(
                () -> assertEquals(250, car.getVolume()),
                () -> assertEquals("BMW", car.getName()),
                () -> assertEquals(Color.RED, car.getColor())
        );
    }

    @Test
    public void testCar4() throws ColorException {
        int volume = 270;
        String name = "Porsche";
        Car car = new Car(volume, name, "BLUE");
        assertAll(
                () -> assertEquals(270, car.getVolume()),
                () -> assertEquals("Porsche", car.getName()),
                () -> assertEquals(Color.BLUE, car.getColor())
        );
    }

    @Test
    public void testCar5() throws ColorException {
        Car car = new Car("GREEN");
        assertAll(
                () -> assertEquals(250, car.getVolume()),
                () -> assertEquals("BMW", car.getName()),
                () -> assertEquals(Color.GREEN, car.getColor())
        );
    }

    @Test
    public void setVolumeAndNameAndColor1() throws ColorException {
        Car car = new Car(150, "Nissan", Color.BLUE);
        car.setVolume(180);
        car.setName("KIA");
        car.setColor(Color.GREEN);
        assertAll(
                () -> assertEquals(180, car.getVolume()),
                () -> assertEquals("KIA", car.getName()),
                () -> assertEquals(Color.GREEN, car.getColor())
        );
    }

    @Test
    public void setVolumeAndNameAndColor2() throws ColorException {
        Car car = new Car(150, "Nissan", Color.BLUE);
        car.setVolume(180);
        car.setName("KIA");
        car.setColor("GREEN");
        assertAll(
                () -> assertEquals(180, car.getVolume()),
                () -> assertEquals("KIA", car.getName()),
                () -> assertEquals(Color.GREEN, car.getColor())
        );
    }

    @Test
    public void testEqualsCar() throws ColorException {
        Car car1 = new Car(100, "Toyota", "GREEN");
        Car car2 = new Car(100, "Toyota", Color.GREEN);
        Car car3 = new Car(120, "BMW", Color.BLUE);
        Car car4 = new Car(100, "Nissan", "RED");
        assertEquals(car1, car2);
        assertNotEquals(car1, car3);
        assertNotEquals(car1, car4);
        assertNotEquals(car3, car4);
    }
}
