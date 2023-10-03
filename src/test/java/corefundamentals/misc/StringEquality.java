package corefundamentals.misc;

/**
 * Created by sca820 on 24 mars, 2023
 */
public class StringEquality {
    public static void main(String[] args) {
        String str1 = "Welcome";

        String str2 = "Welcome";

        String str3 = new String("Welcome");

        System.out.println(str1==str2); //true
        System.out.println(str1==str3); //false
    }
}
