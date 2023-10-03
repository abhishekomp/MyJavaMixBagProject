package corefundamentals.string_use_cases;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by sca820 on 18 okt., 2022
 */
public class DecimalFormatDemo {
    public static void main(String[] args) {
        double allowanceAllotment = 40.00;
        int numberOfKids = 3;

        double allowancePerKid = allowanceAllotment/numberOfKids;

        System.out.println("Each child will receive $" + allowancePerKid);
        System.out.printf("Each child will receive $%.2f\n", allowancePerKid);    //will print "Each child will receive $13,33"

        DecimalFormat dfWithZero = new DecimalFormat("0.00");
//        DecimalFormat df = new DecimalFormat(".##");
//        System.out.println("Each child will receive $" + df.format(allowancePerKid) +
//                " out of total $" + df.format(allowanceAllotment));
        System.out.println("Total allotment was $" + dfWithZero.format(allowanceAllotment));

        System.out.println("Formatted String " + String.format("$%.2f", allowancePerKid));
        //https://stackoverflow.com/questions/5236056/force-point-as-decimal-separator-in-java
        System.out.println("Formatted String with Locale ROOT" + String.format(Locale.ROOT, "$%.2f", allowancePerKid));
    }

    public String formatNumberUsingComma(int number) {
        DecimalFormat df = new DecimalFormat("$#,##0.00");  //did not introduce dot as decimal separator
        return df.format(number);
    }

    //this method takes int as input and produces stringified output for that int
    //So 10 gets printed as $10.00
    //So 100 gets printed as $100.00
    //1000 gets printed as $1,000.00
    //10000 gets printed as $10,000.00
    //1 Lakh gets printed as $100,000.00
    //10 lakh aka 1 million gets printed as $1,000,000.00
    public String formatUsingDecimalSymbol(int num) {
        DecimalFormatSymbols decimalSymbols = DecimalFormatSymbols.getInstance();
        decimalSymbols.setDecimalSeparator('.');
        decimalSymbols.setGroupingSeparator(',');
        return new DecimalFormat("$#,##0.00", decimalSymbols).format(num);
    }
}
