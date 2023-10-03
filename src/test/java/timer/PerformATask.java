package timer;

import java.util.TimerTask;

public class PerformATask extends TimerTask {

    @Override
    public void run() {
        System.out.println("Task completed");
    }
}
