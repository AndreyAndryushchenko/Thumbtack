package net.thumbtack.school.misc.v2;

import net.thumbtack.school.iface.v2.Colored;

import java.util.Objects;

public class Dog implements Colored {
    private int age;
    private int color;

    public Dog(int age, int color) {
        this.age = age;
        this.color = color;
    }

    public Dog(int color) {
        this(1, color);
    }

    public Dog() {
        this(1);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
