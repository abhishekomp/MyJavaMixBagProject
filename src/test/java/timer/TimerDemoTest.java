package timer;

import org.junit.jupiter.api.Test;

import java.util.Timer;

public class TimerDemoTest {

    @Test
    void test_runTaskOnce() {
        TimerDemo timerDemo = new TimerDemo();
        timerDemo.runTaskOnce();
        System.out.println("After runTaskOnce");
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void test_runTask_Once() {
        System.out.println("Active threads at CHECKPOINT 1: " + Thread.activeCount());
        Timer timer = new Timer();
        timer.schedule(new PerformATask(), 5000);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Active threads at CHECKPOINT 2: " + Thread.activeCount());
        timer.cancel();
        System.out.println("Active threads at CHECKPOINT 3: " + Thread.activeCount());
    }
}
