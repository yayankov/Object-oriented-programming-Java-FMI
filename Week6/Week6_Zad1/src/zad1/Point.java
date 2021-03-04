package zad1;

public class Point {
    private int[] coords;

    public Point(int[] coords) {
        setCoords(coords);
    }

    public Point() {
        this(new int[2]);
    }

    public Point(Point p) {
        this(p.coords);
    }

    public int[] getCoords() {
        int[] temp = new int[coords.length];

        for (int i = 0; i < coords.length; i++) {
            temp[i] = coords[i];
        }
        return temp;
    }

    public void setCoords(int[] coords) {
        if (coords != null && coords.length == 2) {
            this.coords = new int[2];
            for (int i = 0; i < coords.length; i++) {
                this.coords[i] = coords[i];
            }
        } else {
            this.coords = new int[2];
        }
    }

    @Override
    public String toString() {
        return String.format("(%d; %d)",
                coords[0], coords[1]); //(x; y)
    }
}
