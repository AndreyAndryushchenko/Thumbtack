package net.thumbtack.school.figures.v2;

import net.thumbtack.school.iface.v2.Colored;

import java.util.Objects;

public class ColoredCircle extends Circle implements Colored {
    private int color;

    public ColoredCircle(Point center, int radius, int color) {
        super(center, radius);
        this.color = color;
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, int color) {
        this(new Point(xCenter, yCenter), radius, color);
    }

    public ColoredCircle(int radius, int color) {
        this(0, 0, radius, color);
    }

    public ColoredCircle(int color) {
        this(1, color);
    }

    public ColoredCircle() {
        this(1);
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
        if (!(o instanceof ColoredCircle)) return false;
        if (!super.equals(o)) return false;
        ColoredCircle that = (ColoredCircle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
