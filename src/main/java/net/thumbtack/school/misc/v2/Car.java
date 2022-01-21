package net.thumbtack.school.misc.v2;

import net.thumbtack.school.iface.v2.Colored;

import java.util.Objects;

public class Car implements Colored {
    private int volume;
    private String name;
    private int color;

    public Car(int volume, String name, int color) {
        this.volume = volume;
        this.name = name;
        this.color = color;
    }

    public Car(int color) {
        this(250, "BMW", color);
    }

    public Car() {
        this(5);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return volume == car.volume &&
                color == car.color &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, name, color);
    }
}
