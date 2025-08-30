package builder_pattern.builder_3_demo;

public class Main {
    // Example main method for usage/demo
    public static void main(String[] args) {
        // Approach 1: Using the static factory method of User.of() to create a User instance in one line
        // Quick static factory: required fields only
        User admin = User.of("alice", "ADMIN");
        System.out.println(admin); // User{username='alice', email='null', role='ADMIN'}

        // Approach 2: Using the static factory method to create the Builder instance and then chain setters
        // Using the builder for full/optional configuration
        // now to get the Builder instance, we must provide the required field (username) and we are not required to do new User.Builder()
        // because of the static method User.builder() returns the Builder instance
        //User.Builder bobBuilder = User.builder("bob");

        User complexUser = User.builder("bob")
                .email("bob@example.com")
                .role("REGULAR")
                .build();
        System.out.println(complexUser); // User{username='bob', email='bob@example.com', role='REGULAR'}

        // Approach 3: Using the new User.Builder() constructor directly (less preferred)
        User guest = new User.Builder("carol")
                .role("GUEST")
                .build();
        System.out.println(guest); // User{username='carol', email='null', role='GUEST'}

        // Omit optional fields with builder (set only required)
        User userWithOnlyRequired = User.builder("eve").build();
        System.out.println(userWithOnlyRequired); // User{username='eve', email='null', role='null'}
    }
}
