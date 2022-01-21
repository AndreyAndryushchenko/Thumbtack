package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;

import java.util.Objects;

public class Dog implements Colored {
    private int age;
    private Color color;

    public Dog(int age, Color color) throws ColorException {
        this.age = age;
        setColor(color);
    }

    public Dog(Color color) throws ColorException {
        this(1, color);
    }

    public Dog() throws ColorException {
        this(Color.RED);
    }

    public Dog(int age, String colorString) throws ColorException {
        this.age = age;
        setColor(colorString);
    }

    public Dog(String colorString) throws ColorException {
        this(1, colorString);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        if (!(o instanceof Dog)) return false;
        Dog dog = (Dog) o;
        return color == dog.color &&
                age == dog.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, age);
    }
}
