package assertion_utils;

public class Example {
    public static void main(String[] args) {
        try {
            Asserter.Arg.hasText("  ", "testArg");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        int maxLength = 5;
        String val = "abcdef";
        try {
            Asserter.Arg.isTrue(val.length() <= maxLength, "String must be at most %d chars, got: %s", maxLength, val);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
