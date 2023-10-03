package comparingdemo;

import java.util.List;

public class Passenger implements Comparable<Passenger>{
    String name;
    int memberLevel;    //3 (highest level), 2, 1
    int memberDays;

    public Passenger(){
        //no-arg constructor
    }

    public Passenger(String name, int memberLevel, int memberDays){
        this.name = name;
        this.memberLevel = memberLevel;
        this.memberDays = memberDays;
    }

    public String getName() {
        return name;
    }

    public int getMemberLevel() {
        return memberLevel;
    }

    public int getMemberDays() {
        return memberDays;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", memberLevel=" + memberLevel +
                ", memberDays=" + memberDays +
                '}';
    }

    @Override
    public int compareTo(Passenger o) {
        int returnValue = this.memberLevel - o.memberLevel;
        //int returnValue = o.memberLevel - this.memberLevel;
//        if(returnValue == 0) {
//            returnValue = o.memberDays - this.memberDays;
            //returnValue = this.memberDays - o.memberDays;
        //}
        return returnValue;
    }

    public static List<Passenger> getPassengers() {
        return List.of(
                new Passenger("Abhay", 2, 80),
                new Passenger("Harish", 3, 120),
                new Passenger("Mohan", 4, 110),
                new Passenger("Amit", 1, 90),
                new Passenger("Suresh", 5, 100)
        );
    }
}
