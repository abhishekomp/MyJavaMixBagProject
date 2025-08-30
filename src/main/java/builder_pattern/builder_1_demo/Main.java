package builder_pattern.builder_1_demo;

public class Main {
    public static void main(String[] args) {
        // Stepwise, readable creation:
        User user = new User.Builder()
                .username("alice")
                .email("alice@example.com")
                .role("ADMIN")
                .build(); // <-- This finalizes the build and returns the immutable User

        System.out.println(user);

        // You can also omit fields (simulate optional ones):
        User user2 = new User.Builder()
                .username("bob")
                .role("REGULAR")
                .build();

        System.out.println(user2);
    }
}