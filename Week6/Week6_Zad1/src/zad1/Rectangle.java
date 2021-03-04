package zad1;

public class Rectangle extends Point { //upper left corner
    private Point lPoint; //lower right corner

    public Rectangle(int[] coords, Point lPoint) {
        super(coords);
        setlPoint(lPoint);
    }

    public Rectangle() {
        this(new int[2], new Point(new int[]{10,10}));
    }

    public Rectangle(Rectangle r) {
        this(r.getCoords(), new Point(r.lPoint));
    }

    public Point getlPoint() {
        return new Point(lPoint);
    }

    public void setlPoint(Point lPoint) {
        if (lPoint != null) {
            this.lPoint = new Point(lPoint);
        } else {
            this.lPoint = new Point(new int[]{10,10});
        }
    }

    public int measure(){
        return 2 * ((lPoint.getCoords()[0] - this.getCoords()[0])
                + (lPoint.getCoords()[1] - this.getCoords()[1]));
        //Math.abs - модул
    }

    @Override
    public String toString() {
        return String.format("Upper left corner coords: %s\n" +
                "Lower right corner coords: %s", super.toString(),
                lPoint.toString());
        //Upper left corner coords: (x; y)
        //Lower right corner coords: (x; y)
    }
}
