package corefundamentals.interfacedemo.demoOne;

public class WelcomeMessageSender implements MessageSendInterface {
    @Override
    public String sendMessage(String name) {
        return "Welcome " + name;
    }
}
