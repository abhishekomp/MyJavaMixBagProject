package corefundamentals.staticmethod;

//https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html
/*

    Instance methods can access instance variables and instance methods directly.
    Instance methods can access class variables and class methods directly.
    Class methods can access class variables and class methods directly.
    Class methods cannot access instance variables or instance methods directly—they must use an object reference. Also, class methods cannot use the this keyword as there is no instance for this to refer to.

 */
public class Bicycle {
        private int cadence;
        private int gear;
        private int speed;
        private int id;
        private static int numberOfBicycles = 0;

    public Bicycle(int cadence, int gear, int speed, int id) {
        this.cadence = cadence;
        this.gear = gear;
        this.speed = speed;
        //this.id = id;

        // increment number of Bicycles and assign ID number
        this.id = ++numberOfBicycles;
    }

    public int getCadence() {
        return cadence;
    }

    public void setCadence(int cadence) {
        this.cadence = cadence;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNumberOfBicycles() {
        return numberOfBicycles;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }
}
