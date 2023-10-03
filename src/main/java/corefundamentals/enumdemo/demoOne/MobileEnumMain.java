package corefundamentals.enumdemo.demoOne;

/**
 * Created by sca820 on 13 sep., 2022
 */
public class MobileEnumMain {
    public static void main(String args[]) {

        System.out.println("CellPhone List:");
        for(Mobile m : Mobile.values()) {
            System.out.println(m + " costs " + m.showPrice() + " dollars");
        }

        Mobile ret;
        ret = Mobile.valueOf("Samsung");
        System.out.println("Selected : " + ret + " has price " + ret.showPrice());

        Mobile anotherMobile;
        anotherMobile = Mobile.valueOf("Apple");
        System.out.println("Selected : " + anotherMobile);
    }
}
