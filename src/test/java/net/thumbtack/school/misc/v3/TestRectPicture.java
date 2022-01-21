package net.thumbtack.school.misc.v3;

import net.thumbtack.school.figures.v3.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRectPicture {
    @Test
    public void testRectPicture1() {
        Point position = new Point(0, 0);
        int length = 100;
        int width = 50;
        RectPicture rp = new RectPicture(position, length, width);
        assertAll(
                () -> assertEquals(0, rp.getPosition().getX()),
                () -> assertEquals(0, rp.getPosition().getY()),
                () -> assertEquals(100, rp.getLength()),
                () -> assertEquals(50, rp.getWidth())
        );
    }

    @Test
    public void testRectPicture2() {
        int length = 150;
        int width = 150;
        RectPicture rp = new RectPicture(10, 10, length, width);
        assertAll(
                () -> assertEquals(10, rp.getPosition().getX()),
                () -> assertEquals(10, rp.getPosition().getY()),
                () -> assertEquals(150, rp.getLength()),
                () -> assertEquals(150, rp.getWidth())
        );
    }

    @Test
    public void testRectPicture3() {
        int length = 100;
        int width = 100;
        RectPicture rp = new RectPicture(length, width);
        assertAll(
                () -> assertEquals(0, rp.getPosition().getX()),
                () -> assertEquals(0, rp.getPosition().getY()),
                () -> assertEquals(100, rp.getLength()),
                () -> assertEquals(100, rp.getWidth())
        );
    }

    @Test
    public void testRectPicture4() {
        RectPicture rp = new RectPicture();
        assertAll(
                () -> assertEquals(0, rp.getPosition().getX()),
                () -> assertEquals(0, rp.getPosition().getY()),
                () -> assertEquals(50, rp.getLength()),
                () -> assertEquals(50, rp.getWidth())
        );
    }

    @Test
    public void testSetPositionAndLengthAndWidth() {
        Point position = new Point(0, 0);
        int length = 100;
        int width = 50;
        RectPicture rp = new RectPicture(position, length, width);
        rp.setLength(200);
        rp.setWidth(100);
        rp.setPosition(new Point(100, 100));
        assertAll(
                () -> assertEquals(100, rp.getPosition().getX()),
                () -> assertEquals(100, rp.getPosition().getY()),
                () -> assertEquals(200, rp.getLength()),
                () -> assertEquals(100, rp.getWidth())
        );
    }

    @Test
    public void testMovableRectPicture() {
        RectPicture rp = new RectPicture(new Point(), 200, 100);
        rp.moveTo(100, 50);
        assertAll(
                () -> assertEquals(100, rp.getPosition().getX()),
                () -> assertEquals(50, rp.getPosition().getY())
        );
        rp.moveTo(new Point(200, 100));
        assertAll(
                () -> assertEquals(200, rp.getPosition().getX()),
                () -> assertEquals(100, rp.getPosition().getY())
        );
        rp.moveRel(70, 90);
        assertAll(
                () -> assertEquals(270, rp.getPosition().getX()),
                () -> assertEquals(190, rp.getPosition().getY())
        );
    }

    @Test
    public void testResize() {
        RectPicture rp = new RectPicture(new Point(), 200, 100);
        rp.resize(2.5);
        assertAll(
                () -> assertEquals(500, rp.getLength()),
                () -> assertEquals(250, rp.getWidth()),
                () -> assertEquals(0, rp.getPosition().getX()),
                () -> assertEquals(0, rp.getPosition().getY())
        );
    }

    @Test
    public void testStretch() {
        RectPicture rp = new RectPicture(new Point(), 200, 100);
        rp.stretch(2.5, 1.5);
        assertAll(
                () -> assertEquals(500, rp.getLength()),
                () -> assertEquals(150, rp.getWidth()),
                () -> assertEquals(0, rp.getPosition().getX()),
                () -> assertEquals(0, rp.getPosition().getY())
        );
    }

    @Test
    public void testGetArea() {
        RectPicture rp = new RectPicture(new Point(), 200, 100);
        assertEquals(20000, rp.getArea());
    }

    @Test
    public void testEquals() {
        RectPicture rp1 = new RectPicture(new Point(), 200, 100);
        RectPicture rp2 = new RectPicture(new Point(), 200, 100);
        RectPicture rp3 = new RectPicture(new Point(10, 10), 200, 100);
        RectPicture rp4 = new RectPicture(new Point(15, 15), 250, 50);
        assertEquals(rp1, rp2);
        assertNotEquals(rp1, rp3);
        assertNotEquals(rp3, rp4);
    }
}
