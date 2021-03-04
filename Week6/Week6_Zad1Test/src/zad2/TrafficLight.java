package zad2;

public enum TrafficLight {
    //1 second = 1000 milliseconds
    RED(15_000),
    GREEN(25_000),
    YELLOW(5_000);

    private final int duration;

    private TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
