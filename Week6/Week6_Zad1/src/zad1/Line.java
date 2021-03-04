package zad1;

public class Line extends Point{ //starting point
    private Point ePoint; //ending point

    public Line(int[] coords, Point ePoint) {
        super(coords);
        setePoint(ePoint);
    }

    public Line() {
        this(new int[2], new Point
                (new int[]{10,10}));
    }

    public Line(Line l) {
        this(l.getCoords(), new Point(l.ePoint));
    }

    public Point getePoint() {
        return new Point(ePoint);
    }

    public void setePoint(Point ePoint) {
        if (ePoint != null) {
            this.ePoint = new Point(ePoint);
        } else {
            this.ePoint = new Point
                    (new int[]{10,10});
        }
    }

    public double measure(){
        return Math.sqrt(
                (ePoint.getCoords()[0] - this.getCoords()[0])
        * (ePoint.getCoords()[0] - this.getCoords()[0])
         + (ePoint.getCoords()[1] - this.getCoords()[1])
        * (ePoint.getCoords()[1] - this.getCoords()[1]));
        // koren ot (x^2 + y^2)
    }

    @Override
    public String toString() {
        return String.format("Starting point coords: %s\n" +
                "ending point coords: %s", super.toString(),
                ePoint.toString());
        //Starting point coords: (x; y)
        //Ending point coords: (x; y)
    }
}
