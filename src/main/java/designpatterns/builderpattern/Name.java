package designpatterns.builderpattern;

//https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#inner-class-and-nested-static-class-example
public class Name {
    private String firstName;
    private String surname;

    private Name(Builder builder) {
        this.firstName = builder.firstName;
        this.surname = builder.surname;
    }

    public static class Builder {
        private String firstName;
        private String surname;

        public Builder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder surname(final String surname) {
            this.surname = surname;
            return this;
        }

        //https://stackoverflow.com/questions/32567208/best-way-to-verify-string-is-empty-or-null
        public Name build() {
            //if(firstName == null || surname == null)
            if(firstName == null || firstName.chars().allMatch(Character::isWhitespace))
                throw new IllegalStateException("First name and surname are needed");
            return new Name(this);
        }   //Remember, static inner class behave just as any other top level class. A top level another class can invoke the constructor of any other top level class. The same is happening here.
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
