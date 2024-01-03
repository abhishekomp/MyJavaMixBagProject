package corefundamentals.interfacedemo.functionInterfaceDemo;

import java.util.function.Function;

public class ClientProgram {
    public static void main(String[] args) {
        String name = "Abhikriti";
        Function<String, String> welcomeMsgSender = message -> "Welcome " + message;
        Function<String, String> thenAddHowAreYou = message -> message + " How are you today?";
        //System.out.println(welcomeMsgSender.apply(name));
        System.out.println(welcomeMsgSender.apply(name));
    }
}
