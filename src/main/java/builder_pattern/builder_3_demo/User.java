package builder_pattern.builder_3_demo;

public class User {

    // REQUIRED field
    private final String username;
    // OPTIONAL fields
    private final String email;
    private final String role;

    // Private constructor enforces controlled creation
    private User(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.role = builder.role;
    }

    // Static factory method ("quick create" for common/simple cases)
    public static User of(String username, String role) {
        // You can include checks here for required fields
        if (username == null || role == null) {
            throw new IllegalArgumentException("username and role are required");
        }
        return new Builder(username).role(role).build();
    }

    // Static builder entry point for more flexible construction
    // now to get the Builder instance, we must provide the required field (username) and we are not required to do new User.Builder()
    // because of the static method User.builder() returns the Builder instance
    // If we do not provide this method then we would have to do new User.Builder("username") to get the Builder instance
    // and then call the chainable setters on it to create the User object
    public static Builder builder(String username) {
        return new Builder(username);
    }

    // Nested static Builder class
    public static class Builder {
        private final String username; // required
        private String email;          // optional
        private String role;           // optional

        // REQUIRED field passed to builder constructor
        public Builder(String username) {
            if (username == null) {
                throw new IllegalArgumentException("username is required");
            }
            this.username = username;
        }

        // Chainable setter for email
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        // Chainable setter for role
        public Builder role(String role) {
            this.role = role;
            return this;
        }

        // build() creates the actual User object, after validation
        public User build() {
            // You could enforce role (or any other field) here if needed
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', email='" + email + "', role='" + role + "'}";
    }
}