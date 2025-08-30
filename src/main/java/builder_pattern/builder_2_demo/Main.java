package builder_pattern.builder_2_demo;

public class Main {
    public static void main(String[] args) {
        // username is **required**
        User user1 = new User.Builder("alice")
                .email("alice@example.com") // optional
                .role("ADMIN")              // optional
                .build();

        User user2 = new User.Builder("bob")
                .role("REGULAR")            // optional
                .build();

        // Uncommenting the following line would NOT cause a compile-time error but a runtime Exception because username is required in Builder constructor
        // User user3 = new User.Builder(null).build();  // would throw Exception defined in Builder constructor

        System.out.println(user1);
        System.out.println(user2);
    }
}