package corefundamentals.interfacedemo.demoOne;

public class ByeMessageSender implements MessageSendInterface {
    @Override
    public String sendMessage(String name) {
        return "Bye " + name;
    }
}
