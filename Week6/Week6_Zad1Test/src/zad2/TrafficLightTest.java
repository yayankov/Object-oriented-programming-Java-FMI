package zad2;

public class TrafficLightTest {

    public static void main(String[] args) {
        long ct; //current time
        long tm = System.currentTimeMillis(); //time manage - with light times
        long endTime = tm + 90_000;
        while(true){
            ct = System.currentTimeMillis();
            for (TrafficLight t: TrafficLight.values()) {
                System.out.println(t);
                tm += t.getDuration();
                while (tm >= ct){
                    ct = System.currentTimeMillis();
                    if (ct > endTime){
                        System.exit(0);
                    }
                }
            }
        }
    }
}
