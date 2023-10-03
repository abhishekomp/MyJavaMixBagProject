package corefundamentals.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericCollectionUseCases {
    @Test
    public void showDeleteOperationOnArrayList() {
        List<String> list = new ArrayList<>();
        list.add("This");
        list.add("is");
        list.add("a");
        list.add("sentence");

        System.out.println("list = " + list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println("i = " + i + " -> " + list.get(i));
        }
        System.out.println("---------------");
        list.remove(1);
        for(int i = 0; i < list.size(); i++) {
            System.out.println("i = " + i + " -> " + list.get(i));
        }
    }
}