package timer;

import java.util.Timer;

public class TimerDemoWithMain {
    public static void main(String[] args) {
        PerformATask task = new PerformATask();
        Timer timer = new Timer();
        timer.schedule(task, 5000);
        timer.cancel();
    }
}
