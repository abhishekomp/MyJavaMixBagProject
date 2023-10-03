package designpatterns.builderpattern;

public class Main {
    public static void main(String[] args) {

        final Name name = new Name.Builder().firstName("John")
                                            .surname("Doe")
                                            .build();

        final Address address = new Address.Builder().streetName("Belfast Street")
                .city("Gothenburg")
                .zipCode("41556")
                .build();

        final Account account = new Account.Builder().address(address)
                .name(name)
                .email("a@gmail.com")
                .id(1)
                .build();

        System.out.println("account = " + account);
    }
}
