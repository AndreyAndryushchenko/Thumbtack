package net.thumbtack.school.figures.v3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPoint {
    @Test
    public void testPoint1() {
        Point point = new Point(10, 20);
        assertAll(
                () -> assertEquals(10, point.getX()),
                () -> assertEquals(20, point.getY())
        );
    }

    @Test
    public void testPoint2() {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(point1);
        assertAll(
                () -> assertEquals(10, point2.getX()),
                () -> assertEquals(20, point2.getY())
        );
    }

    @Test
    public void testPoint3() {
        Point point = new Point();
        assertAll(
                () -> assertEquals(0, point.getX()),
                () -> assertEquals(0, point.getY())
        );
    }

    @Test
    public void testSetXAndY() {
        Point point = new Point(100, 100);
        point.setX(50);
        point.setY(-30);
        assertAll(
                () -> assertEquals(50, point.getX()),
                () -> assertEquals(-30, point.getY())
        );
    }

    @Test
    public void testMovePoint() {
        Point point = new Point(35, 50);
        point.moveTo(80, 90);
        assertAll(
                () -> assertEquals(80, point.getX()),
                () -> assertEquals(90, point.getY())
        );
        point.moveTo(new Point(100, -230));
        assertAll(
                () -> assertEquals(100, point.getX()),
                () -> assertEquals(-230, point.getY())
        );
        point.moveRel(-50, 30);
        assertAll(
                () -> assertEquals(50, point.getX()),
                () -> assertEquals(-200, point.getY())
        );
    }

    @Test
    public void testPointsAreEqual1() {
        Point point1 = new Point(100, 100);
        Point point2 = new Point(100, 100);
        assertEquals(point1, point2);
    }

    @Test
    public void testPointsAreEqual2() {
        Point point1 = new Point(100, 100);
        Point point2 = new Point();
        assertNotEquals(point1, point2);
        point2.moveRel(100, 100);
        assertEquals(point1, point2);
    }

    @Test
    public void testPointsAreEqual3() {
        Point point1 = new Point(100, 100);
        Point point2 = new Point(point1);
        assertEquals(point1, point2);
    }
}
