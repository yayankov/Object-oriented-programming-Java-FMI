package zad1Test;
/*
import zad1.Line;
import zad1.Point;
import zad1.Rectangle;

 */

import zad1.*;

public class MeasureTest {

    public static void main(String[] args) {
        Point p = new Point();
        Point p2 = new Point(new int[]{10, 20});

        Line l = new Line(p.getCoords(), p2);
        Rectangle r = new Rectangle(p.getCoords(), p2);

        System.out.println("Line length: " + l.measure());
        System.out.println("Rectangle perimeter: " + r.measure());
    }
}
