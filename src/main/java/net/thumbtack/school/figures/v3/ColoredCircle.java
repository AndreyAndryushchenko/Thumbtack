package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;

import java.util.Objects;

public class ColoredCircle extends Circle implements Colored {
    private Color color;

    public ColoredCircle(Point center, int radius, Color color) throws ColorException {
        super(center, radius);
        setColor(color);
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, Color color) throws ColorException {
        this(new Point(xCenter, yCenter), radius, color);
    }

    public ColoredCircle(int radius, Color color) throws ColorException {
        this(0, 0, radius, color);
    }

    public ColoredCircle(Color color) throws ColorException {
        this(1, color);
    }

    public ColoredCircle() throws ColorException {
        this(Color.RED);
    }

    public ColoredCircle(Point center, int radius, String colorString) throws ColorException {
        this(center, radius, Color.colorFromString(colorString));
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, String colorString) throws ColorException {
        this(new Point(xCenter, yCenter), radius, colorString);
    }

    public ColoredCircle(int radius, String colorString) throws ColorException {
        this(0, 0, radius, colorString);
    }

    public ColoredCircle(String colorString) throws ColorException {
        this(1, colorString);
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
