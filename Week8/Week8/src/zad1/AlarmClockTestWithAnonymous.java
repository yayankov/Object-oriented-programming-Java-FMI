package zad1;

public class AlarmClockTestWithAnonymous {
    private AlarmClock clock;

    public AlarmClockTestWithAnonymous(int rings) {
        this.clock = new AlarmClock(rings);
        this.clock.addAlarmListener(new AlarmListener() {
            @Override
            public void alarmActionPerformed(AlarmEvent args) {
                System.out.printf("Rings: %d%n", clock.getNrings());
            }
        });
    }

    public AlarmClock getClock() {
        return clock;
    }

    public static void main(String[] args) {
        AlarmClockTestWithAnonymous alarm =
                new AlarmClockTestWithAnonymous(10);
        System.out.println("Rings with no time duration between them.");
        alarm.getClock().start();
    }
}
