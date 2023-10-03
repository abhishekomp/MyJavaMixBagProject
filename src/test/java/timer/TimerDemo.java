package timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    //https://www.youtube.com/watch?v=QEF62Fm81h4
    //https://www.youtube.com/watch?v=tKSe8DAkrYk
    public void runTaskOnce() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task is complete");
            }
        };
        timer.schedule(task, 5000);
    }
}
