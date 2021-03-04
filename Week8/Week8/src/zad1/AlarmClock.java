package zad1;

import java.time.LocalDateTime;

public class AlarmClock {
    private AlarmListener alarm;
    private int nrings; // define in the constructor

    public AlarmClock(int nrings) {
        this.nrings = nrings;
    }

    public int getNrings() {
        return nrings;
    }

    public void setNrings(int nrings) {
        if (nrings > 0) {
            this.nrings = nrings;
        } else {
            this.nrings = 3;
        }
        //this.nrings = nrings > 0? nrings : 3;
    }

    public void addAlarmListener (AlarmListener a){
        alarm = a;
    }

    public void onAlarm(AlarmEvent e)
    {
        if (alarm != null)
        {
//Invoke the event handler.
            alarm.alarmActionPerformed(e);
        }
    }

    // event handling method
    public void start()
    {
        for (;;)
        {
            nrings--;
            if (nrings<0)
            {
                break;
            }
            else
            {
                AlarmEvent e = new AlarmEvent (nrings);
                onAlarm(e);
            }
        }
    }

    public void startWithTime(int durationBetweenRings) {
        int passedSeconds = 0;
        int newTime;
        for (; ; ) {
            newTime = LocalDateTime.now().getSecond() / durationBetweenRings;
            if (newTime > passedSeconds) {
                nrings--;
                if (nrings < 0) {
                    break;
                } else {
                    AlarmEvent e = new AlarmEvent (nrings);
                    onAlarm(e);
                }
            }
            passedSeconds = newTime;
        }
    }

}
