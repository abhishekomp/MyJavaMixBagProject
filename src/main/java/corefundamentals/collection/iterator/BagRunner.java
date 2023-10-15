package corefundamentals.collection.iterator;

public class BagRunner {
    public static void main(String[] args) {
        Bag<String> myBag = new Bag<>();
        myBag.add("This");
        myBag.add("is");
        myBag.add("a");
        myBag.add("Custom");
        myBag.add("Iterator");
        myBag.add("implementation");

        /*  Just that Bag class implements Iterable and has an Iterator object,
            we can use the for loop on myBag object just like we can use for loop on the List objects.
         */
        for(String str: myBag) {
            System.out.println(str);
        }
    }
}
