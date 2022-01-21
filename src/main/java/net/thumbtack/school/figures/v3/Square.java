package net.thumbtack.school.figures.v3;

import java.util.Objects;

public class Square extends Figure {
    private Point leftTop;
    private int size;

    public Square(Point leftTop, int size) {
        super();
        this.leftTop = leftTop;
        this.size = size;
    }

    public Square(int xLeft, int yTop, int size) {
        this(new Point(xLeft, yTop), size);
    }

    public Square(int size) {
        this(0, -size, size);
    }

    public Square() {
        this(1);
    }

    public Point getTopLeft() {
        return leftTop;
    }

    public Point getBottomRight() {
        return new Point(leftTop.getX() + size, leftTop.getY() + size);
    }

    public void setTopLeft(Point topLeft) {
        this.leftTop = topLeft;
    }

    public int getLength() {
        return size;
    }

    @Override
    public void moveTo(int x, int y) {
        leftTop.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        leftTop.moveRel(dx, dy);
    }

    @Override
    public void resize(double ratio) {
        size = ((int) (size * ratio));
    }

    @Override
    public double getArea() {
        return size * size;
    }

    @Override
    public double getPerimeter() {
        return 4 * size;
    }

    @Override
    public boolean isInside(int x, int y) {
        return x >= leftTop.getX() && x <= leftTop.getX() + size &&
                y >= leftTop.getY() && y <= leftTop.getY() + size;
    }

    public boolean isIntersects(Square square) {
        return leftTop.getX() <= square.getBottomRight().getX() &&
                leftTop.getX() + size >= square.getTopLeft().getX() &&
                leftTop.getY() <= square.getBottomRight().getY() &&
                leftTop.getY() + size >= square.getTopLeft().getY();
    }

    public boolean isInside(Square square) {
        return isInside(square.getTopLeft()) && isInside(square.getBottomRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return size == square.size &&
                Objects.equals(leftTop, square.leftTop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftTop, size);
    }
}
