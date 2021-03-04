package zad1;

public class AlarmClockTest implements AlarmListener{

    private AlarmClock clock;

    public AlarmClockTest(int nrings) {
        this.clock = new AlarmClock(nrings);
        this.clock.addAlarmListener(this);
    }

    public AlarmClock getClock() {
        return clock;
    }

    @Override
    public void alarmActionPerformed(AlarmEvent args) {
        System.out.printf("Rings: %d%n", clock.getNrings());
    }

    public static void main(String[] args) {
        AlarmClockTest alarm = new AlarmClockTest(10);
        System.out.println("Rings with no time duration between them.");
        alarm.getClock().start();

        alarm.getClock().setNrings(-6); //validation with default 3
        System.out.println("Rings with 3 secs duration between them.");
        alarm.getClock().startWithTime(3);
    }
}
