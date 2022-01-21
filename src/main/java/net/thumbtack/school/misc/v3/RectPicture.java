package net.thumbtack.school.misc.v3;

import net.thumbtack.school.figures.v3.Point;
import net.thumbtack.school.iface.v3.HasArea;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Stretchable;

import java.util.Objects;

public class RectPicture implements Movable, HasArea, Stretchable {
    private Point position;
    private int length;
    private int width;

    public RectPicture(Point position, int length, int width) {
        this.position = position;
        this.length = length;
        this.width = width;
    }

    public RectPicture(int x, int y, int length, int width) {
        this(new Point(x, y), length, width);
    }

    public RectPicture(int length, int width) {
        this(0, 0, length, width);
    }

    public RectPicture() {
        this(50, 50);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void moveTo(int x, int y) {
        position.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        position.moveRel(dx, dy);
    }

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    @Override
    public void resize(double ratio) {
        length = ((int) (getLength() * ratio));
        width = ((int) (getWidth() * ratio));
    }

    @Override
    public void stretch(double xRatio, double yRatio) {
        length = ((int) (getLength() * xRatio));
        width = ((int) (getWidth() * yRatio));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RectPicture)) return false;
        RectPicture that = (RectPicture) o;
        return length == that.length &&
                width == that.width &&
                position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, length, width);
    }
}
