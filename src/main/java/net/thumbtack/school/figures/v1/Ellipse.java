package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Ellipse {
    private Point center;
    private int xAxis;
    private int yAxis;

    public Ellipse(Point center, int xAxis, int yAxis) {
        this.center = center;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this(new Point(xCenter, yCenter), xAxis, yAxis);
    }

    public Ellipse(int xAxis, int yAxis) {
        this(0, 0, xAxis, yAxis);
    }

    public Ellipse() {
        this(1, 1);
    }

    public Point getCenter() {
        return center;
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void moveTo(int x, int y) {
        center.moveTo(x, y);
    }

    public void moveTo(Point point) {
        center = point;
    }

    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        xAxis = ((int) (xAxis * ratio));
        yAxis = ((int) (yAxis * ratio));
    }

    public void stretch(double xRatio, double yRatio) {
        xAxis = ((int) (xAxis * xRatio));
        yAxis = ((int) (yAxis * yRatio));
    }

    public double getArea() {
        return Math.PI * xAxis * yAxis / 4;
    }

    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((xAxis * xAxis + yAxis * yAxis) / (double) (8));
    }

    public boolean isInside(int x, int y) {
        return (4 * (x - center.getX()) * (x - center.getX())) / (xAxis * xAxis) +
                (4 * (y - center.getY()) * (y - center.getY())) / (yAxis * yAxis) <= 1;
    }

    public boolean isInside(Point point) {
        return (4 * (point.getX() - center.getX()) * (point.getX() - center.getX())) / (xAxis * xAxis) +
                (4 * (point.getY() - center.getY()) * (point.getY() - center.getY())) / (yAxis * yAxis) <= 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ellipse)) return false;
        Ellipse ellipse = (Ellipse) o;
        return xAxis == ellipse.xAxis &&
                yAxis == ellipse.yAxis &&
                Objects.equals(center, ellipse.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, xAxis, yAxis);
    }
}
