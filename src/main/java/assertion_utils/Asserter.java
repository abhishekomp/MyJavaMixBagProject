package assertion_utils;

public class Asserter {

    // Nested class for argument validation logic
    // This utility class can be used throughout the codebase to validate method arguments and throw informative exceptions.
    // Anywhere a method needs to validate its inputs, it can call these static methods.
    // This helps keep validation logic consistent and reduces boilerplate code.
    // Example usage:
    // Asserter.Arg.hasText(someString, "someString");
    // Asserter.Arg.isTrue(someCondition, "Condition failed: %s", details);
    // Check the Example class for usage examples and also the unit tests in AsserterTest.
    public static class Arg{

        /**
         * Checks that a string is not null, not empty, and not just whitespace.
         * @param arg The string to check.
         * @param name Description or parameter name for error message.
         * @param params (Unused here, for API compatibility with isTrue.)
         */
        public static void hasText(String arg, String name, Object... params){
            if(arg == null || arg.trim().isEmpty()){
                //throw new IllegalArgumentException(String.format("Argument '%s' must have text.", String.format(name, params)));
                // Format error message if any placeholders (not used here)
                String msg = String.format("Argument '%s' must not be null or blank.", name);
                throw new IllegalArgumentException(msg);
            }
        }

        /**
         * Checks that the condition (expression) is true, and throws with formatted message if not.
         * Supports substitution parameters using String.format().
         * @param condition The boolean to assert.
         * @param message Error message (can contain %s, %d, etc).
         * @param params Parameters to substitute into the message.
         */
        public static void isTrue(boolean condition, String message, Object... params){
            if(!condition){
                // Use String.format to support message templates with parameters
                String msg = String.format(message, params);
                throw new IllegalArgumentException(msg);
            }
        }
    }
}
