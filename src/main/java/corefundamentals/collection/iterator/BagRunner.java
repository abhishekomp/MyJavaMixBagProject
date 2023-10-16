package corefundamentals.collection.iterator;

import java.util.Iterator;

public class BagRunner {
    public static void main(String[] args) {
        Bag<String> myBag = new Bag<>();
        myBag.add("This");
        myBag.add("is");
        myBag.add("a");
        myBag.add("Custom");
        myBag.add("Iterator");
        myBag.add("implementation");

        //getting the iterator from the myBag object and iterating over the items in the bag
        Iterator<String> iterator = myBag.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        /*  Since the Bag class implements Iterable and has an Iterator object,
            we can use an enhanced for loop on myBag object in the same way we use for loop on the List (ArrayList) object
         */
        for(String str: myBag) {
            System.out.println(str);
        }
    }
}
