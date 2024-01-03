package corefundamentals.interfacedemo.demoOne;

public class ClientProgram {
    public static void main(String[] args) {
        String name = "Abhikriti";

        MessageSendInterface welcomeMsgSender = new WelcomeMessageSender();
        System.out.println(welcomeMsgSender.sendMessage(name));

        MessageSendInterface byeMessageSender = new ByeMessageSender();
        System.out.println(byeMessageSender.sendMessage(name));
    }
}
