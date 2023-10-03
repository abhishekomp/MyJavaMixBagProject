package corefundamentals.multithreading.createThreadOne;

public class CreateThreadRunnable {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        long myNum = 9223372036854775783L;		//this has a higher prime factor
        //myNum = 9223372036854775781L;
        MyCalculations mc = new MyCalculations(myNum);

        Thread t = new Thread(mc);
        t.start();

        Thread mainThread = Thread.currentThread();
        System.out.println("Active threads at this time for this thread group: " + Thread.activeCount());

        int spinner = 0;
        char animation = ' ';
        System.out.print("Calculating  ");

        while(t.isAlive()){
            spinner++;
            switch(spinner){
                case 1:
                    animation = '|';
                    break;
                case 2:
                    animation = '/';
                    break;
                case 3:
                    animation = '-';
                    break;
                case 4:
                    animation = '\\';
                    spinner = 0;
                    break;
            }
            System.out.print("\b"+animation);

            try {
                mainThread.sleep(800);
            }
            catch (InterruptedException e){
                System.out.println("Main thread interrupted");
            }
        }
        System.out.println("Active threads at this time for this thread group: " + Thread.activeCount());
    }	//End of Main
}




