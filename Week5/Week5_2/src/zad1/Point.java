package zad1;

public class Point {
    private double[] coords;

    public Point(double[] coords) {
        setCoords(coords);
    }

    public Point() {
        this(new double[2]);//new double[]{0, 0}
    }

    public Point(Point p) {
        this(p.coords);
    }

    public double[] getCoords() {
        double[] temp;
        temp = new double[2];
        for (int i = 0; i < coords.length; i++) {
            temp[i] = coords[i];
        }
        return temp;
    }

    public void setCoords(double[] coords) {
        if (coords != null && coords.length == 2) {
            this.coords = new double[2];
            for (int i = 0; i < coords.length; i++){
                this.coords[i] = coords[i];
                //възможна валидация за положителни стойности
            }
        } else {
            this.coords = new double[2];
        }
    }

    @Override
    public String toString() {
        return String.format("(%.2f; %.2f)",
                coords[0], coords[1]); //(x; y)
    }
}
