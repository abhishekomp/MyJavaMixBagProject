package builder_pattern.builder_2_demo;

public class User {
    private final String username; // Required
    private final String email;    // Optional
    private final String role;     // Optional

    // Only the builder can construct a User
    private User(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.role = builder.role;
    }

    public static class Builder {
        // Required field
        private final String username;
        // Optional fields
        private String email;
        private String role;

        // REQUIRED field goes in constructor!
        public Builder(String username) {
            if (username == null) {
                throw new IllegalArgumentException("username is required");
            }
            this.username = username;
        }

        // Optionals via setters
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public User build() {
            // Optionally, further validation here
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', email='" + email + "', role='" + role + "'}";
    }
}