package designpatterns.builderpattern;

public class Account {
    private int id;
    private String email;
    private Address address;
    private Name name;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Name getName() {
        return name;
    }

    //Step 1: Create Private Constructor (Builder will be a static nested class inside the Account class)
    private Account(Builder builder) {
        //Step 5
        this.id = builder.id;
        this.email = builder.email;
        this.address = builder.address;
        this.name = builder.name;
    }

    //Step 2: Copy all the properties from the main class i.e. Account class
    public static class Builder {

        private int id;
        private String email;
        private Address address;
        private Name name;

        //Step 3 create this fluent type
        public Builder id(final int id) {
            this.id = id;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder address(final Address address) {
            this.address = address;
            return this;
        }

        public Builder name(final Name name) {
            this.name = name;
            return this;
        }
        //Step 4: Provide the build method that will build the Account object
        public Account build() {
            return new Account(this);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", name=" + name +
                '}';
    }
}
