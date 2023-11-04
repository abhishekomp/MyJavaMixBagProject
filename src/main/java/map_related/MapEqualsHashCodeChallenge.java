package map_related;

import java.util.LinkedHashMap;
import java.util.Map;

//https://javachallengers.com/map-equals-hashcode/
public class MapEqualsHashCodeChallenge {
    public static void main(String[] args) {
        Map<Stark, String> map = new LinkedHashMap<>();
        map.put(new Stark("Arya"), "1");
        map.put(new Stark("Ned"), "2");
        map.put(new Stark("Sansa"), "3");
        map.put(new Stark("Bran"), "4");
        map.put(new Stark("Jaime"), "5");

        System.out.println("map = " + map); //map = {John=4, Ned=2, Sansa=3, Jaime=5}

        map.forEach((k,v) -> System.out.print(v));  //425

    }

    private static class Stark {
        String name;
        Stark(String name){
            this.name = name;
        }
        public boolean equals(Object obj){
            return ((Stark)obj).name.length() == this.name.length();
        }
        public int hashCode() {
            return 4000 << 2 * 2000 / 10000;
        }

        @Override
        public String toString(){
            return name;
        }
    }
}

