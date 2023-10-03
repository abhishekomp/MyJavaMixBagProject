package designpatterns.builderpattern;

public class Address {
    private String streetName;
    private String zipCode;
    private String city;

    private Address(Builder builder) {
        this.streetName = builder.streetName;
        this.zipCode = builder.zipCode;
        this.city = builder.city;
    }

    public static class Builder {
        private String streetName;
        private String zipCode;
        private String city;

        public Builder streetName (final String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder zipCode(final String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder city(final String city) {
            this.city = city;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
