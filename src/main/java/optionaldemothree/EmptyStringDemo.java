package optionaldemothree;

import java.util.Optional;

import static java.util.Optional.*;

public class EmptyStringDemo {

    public String getAName(int nameLength) {
        String name = null;
        if(nameLength == 8) {
            return "Abhikriti";
        }
        return name;
    }

    public Optional<String> getANameOptional(int nameLength) {
        String name = "";
        if(nameLength == 8) {
            return of("Abhikriti");
        }
        return empty();
    }

    public Optional<String> getANameOptionalV2(int nameLength) {
        String name = "";
        if(nameLength == 8) {
            name = "Abhikriti";
        }
        return ofNullable(name);
    }

    public String fetchNewName(int nameLenght) {
        String name = getAName(nameLenght);
        System.out.println("Fetched name = " + name);
        return name;
    }

    public static void main(String[] args) {
        EmptyStringDemo emptyStringDemo = new EmptyStringDemo();
        //emptyStringDemo.fetchNewName(0);
        Optional<String> aNameOptional = emptyStringDemo.getANameOptionalV2(0);
        //String fetch_name = aNameOptional.map(name -> "Fetched name = " + name).orElse("Could not fetch name");
        String fetch_name = aNameOptional.filter(name -> name.length()>0).map(name -> "Fetched name = " + name).orElse("Could not fetch name");
        System.out.println(fetch_name);
        //System.out.println("Fetched name = " + aNameOptional);
    }

}
