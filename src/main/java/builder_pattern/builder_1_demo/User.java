package builder_pattern.builder_1_demo;

public class User {
    private final String username;
    private final String email;
    private final String role;

    // Private constructor: only the builder can create instances
    private User(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.role = builder.role;
    }

    // Static nested Builder class
    public static class Builder {
        private String username;
        private String email;
        private String role;

        // Chainable (fluent) setter methods
        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        // The build() method constructs the actual User
        public User build() {
            // Optionally: validation here (e.g. not null checks)
            return new User(this);
        }
    }

    // For demo: getter and toString
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    @Override
    public String toString() {
        return "User{username='" + username + "', email='" + email + "', role='" + role + "'}";
    }
}