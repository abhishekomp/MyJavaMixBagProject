package misc;

import java.time.Year;
import java.util.Calendar;

public class Elvis {

    // https://github.com/soenkenils/java-puzzlers/blob/master/src/main/java/elvis/Elvis.java
    // Java 8 onwards:
    // int year = Year.now().getValue();
    private static final int CURRENT_YEAR =
            Calendar.getInstance().get(Calendar.YEAR);
    public static final Elvis INSTANCE = new Elvis();
    private final int beltSize;


    private Elvis() {
        this.beltSize = CURRENT_YEAR - 1930;
        System.out.println("Elvis instance created: " + this.beltSize);
    }

    public int beltSize() {
        return beltSize;
    }

    public static void main(String[] args) {
        System.out.println("In main method");
        System.out.println("Elvis wears a size " +
                INSTANCE.beltSize() + " belt.");
    }
}
