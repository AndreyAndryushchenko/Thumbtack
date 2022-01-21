package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Rectangle {

    private Point leftTop;
    private Point rightBottom;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom));
    }

    public Rectangle(int length, int width) {
        this(0, -width, length, 0);
    }

    public Rectangle() {
        this(1, 1);
    }

    public Point getTopLeft() {
        return leftTop;
    }

    public Point getBottomRight() {
        return rightBottom;
    }

    public void setTopLeft(Point topLeft) {
        leftTop = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        rightBottom = bottomRight;
    }

    public int getLength() {
        return rightBottom.getX() - leftTop.getX();
    }

    public int getWidth() {
        return rightBottom.getY() - leftTop.getY();
    }

    public void moveTo(int x, int y) {
        rightBottom.moveTo(getLength() + x, getWidth() + y);
        leftTop.moveTo(x, y);
    }

    public void moveTo(Point point) {
        rightBottom.moveTo(getLength() + point.getX(), getWidth() + point.getY());
        leftTop.moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        leftTop.moveRel(dx, dy);
        rightBottom.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        int dx = ((int) (getLength() * ratio));
        int dy = ((int) (getWidth() * ratio));
        rightBottom = new Point(leftTop.getX() + dx, leftTop.getY() + dy);
    }

    public void stretch(double xRatio, double yRatio) {
        int dx = ((int) (getLength() * xRatio));
        int dy = ((int) (getWidth() * yRatio));
        rightBottom = new Point(leftTop.getX() + dx, leftTop.getY() + dy);
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    public boolean isInside(int x, int y) {
        return x >= leftTop.getX() && x <= rightBottom.getX() && y >= leftTop.getY() && y <= rightBottom.getY();
    }

    public boolean isInside(Point point) {
        return point.getX() >= leftTop.getX() && point.getX() <= rightBottom.getX()
                && point.getY() >= leftTop.getY() && point.getY() <= rightBottom.getY();
    }

    public boolean isIntersects(Rectangle rectangle) {
        return leftTop.getX() <= rectangle.getBottomRight().getX() &&
                rightBottom.getX() >= rectangle.getTopLeft().getX() &&
                leftTop.getY() <= rectangle.getBottomRight().getY() &&
                rightBottom.getY() >= rectangle.getTopLeft().getY();
    }

    public boolean isInside(Rectangle rectangle) {
        return isInside(rectangle.getTopLeft().getX(), rectangle.getTopLeft().getY()) &&
                isInside(rectangle.getBottomRight().getX(), rectangle.getBottomRight().getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(leftTop, rectangle.leftTop) &&
                Objects.equals(rightBottom, rectangle.rightBottom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftTop, rightBottom);
    }
}
