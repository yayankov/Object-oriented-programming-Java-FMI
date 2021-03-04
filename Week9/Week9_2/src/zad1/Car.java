package zad1;

public class Car implements Comparable<Car>{
    private String model;
    private int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int compareTo(Car o){
        if (this.getYear() > o.getYear()){
            return 1;
        }
        if (this.getYear() < o.getYear()){
            return -1;
        }
        return 0;
        //this.getYear() - o.getYear();
    }

    public String toString(){
        return String.format("Model: %s,Year: %d", model, year);
    }
}
