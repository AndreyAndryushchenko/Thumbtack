package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;

import java.util.Objects;

public class Car implements Colored {
    private int volume;
    private String name;
    private Color color;

    public Car(int volume, String name, Color color) throws ColorException {
        this.volume = volume;
        this.name = name;
        setColor(color);
    }

    public Car(Color color) throws ColorException {
        this(250, "BMW", color);
    }

    public Car() throws ColorException {
        this(Color.RED);
    }

    public Car(int volume, String name, String colorString) throws ColorException {
        this.volume = volume;
        this.name = name;
        setColor(colorString);
    }

    public Car(String colorString) throws ColorException {
        this(250, "BMW", colorString);
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
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null)
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        this.color = Color.colorFromString(colorString);
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
