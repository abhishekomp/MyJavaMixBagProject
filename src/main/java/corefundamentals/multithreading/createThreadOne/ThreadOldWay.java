package corefundamentals.multithreading.createThreadOne;

public class ThreadOldWay {
    public static void main(String[] args) {
        //threadOldWay();
        //threadJava8Way();
        threadJava8WayMultipleStatementsInMethodBody();
    }

    private static void threadJava8Way() {
        Thread thread = new Thread(() -> System.out.println("In another thread"));
        thread.start();

        System.out.println("End of main");
    }

    private static void threadJava8WayMultipleStatementsInMethodBody() {
        Thread thread = new Thread(prepareRunnable());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of main");
    }

    private static Runnable prepareRunnable() {
        return () -> {
            System.out.println("In another thread");
            System.out.println("2nd line of statement");
        };
    }

    //this is anonymous class
    private static void threadOldWay() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In another thread");
            }
        });
        thread.start();

        System.out.println("End of main");
    }
}
