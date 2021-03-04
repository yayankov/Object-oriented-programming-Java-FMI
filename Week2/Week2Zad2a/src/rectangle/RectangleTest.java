package rectangle;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        //create default rectangle

        System.out.println(rectangle.toString());

        Rectangle rectangle2 = new Rectangle(1.8736587, 3.28745);
        //create rectangle with given measures
        System.out.println(rectangle2);

        System.out.printf("Area: %.3f, Perimeter: %.3f",
                rectangle2.getArea(), rectangle.getPerimeter());
        //print rectangles area and perimeter
    }
}
