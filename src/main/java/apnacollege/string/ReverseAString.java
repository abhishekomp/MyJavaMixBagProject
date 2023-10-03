package apnacollege.string;

//https://www.youtube.com/watch?v=ZLDwskEhIFg&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=13
//At: 18:50
public class ReverseAString {
    public static void main(String[] args) {

        String str = "hellop";
        for(int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }

    //Approach 2 using String Builder by swapping character using set function of String Builder
}
