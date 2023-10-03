package corefundamentals.string_use_cases;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by sca820 on 18 okt., 2022
 */
public class ConvertStringToBigDecimalDemo {
    public static void main(String[] args) {

//        String value = "1,000,000,000.999999999999999";
//        BigDecimal money = new BigDecimal(value.replaceAll(",", ""));
//        System.out.println(money);

        // Creating instance of BigDecimal in Java
        BigDecimal twentyOne = new BigDecimal("21.015");
        // String constructor behaves as they seen

        BigDecimal twentyTwo = new BigDecimal("22.01");
        BigDecimal _22 = new BigDecimal(22.01);
        // double constructor, doesn't behave as they look

        System.out.println(twentyOne + ", " + twentyTwo + ", " + _22);


        // How to get the scale of BigDecimal number
        int scale = twentyOne.scale();
        System.out.printf("scale of BigDecimal %s is %d %n", twentyOne, scale);
        int _scale = _22.scale();
        System.out.printf("scale of BigDecimal %s is %d %n", _22, _scale);


        //How to set the scale of BigDecimal number
        _22 = _22.setScale(4, RoundingMode.HALF_DOWN);
        // may return a different BigDecimal object
        System.out.printf("new scale of BigDecimal %s is %d %n", _22, _22.scale());


        // Adding two BigDecimal numbers in Java
        BigDecimal sum = twentyOne.add(twentyOne); // adding BigDecimal of same scale
        BigDecimal addition = twentyOne.add(_22);  // adding BigDecimal of different scale
        System.out.printf("sum of %s and %s is %s %n", twentyOne, twentyTwo, sum);
        System.out.printf("addition of %s and %s is %s %n", twentyOne, _22, addition);


        // Subtracting two BigDecimal in Java
        BigDecimal minus = twentyOne.subtract(twentyOne);
        // subtracting BigDecimal of same scale
        BigDecimal subtraction = twentyOne.subtract(_22);
        // subtracting BigDecimal of different scale
        System.out.printf("minus of %s and %s is %s %n", twentyOne, twentyTwo, minus);
        System.out.printf("subtraction of %s and %s is %s %n", twentyOne, _22,
                subtraction);


        // Multiplying BigDecimals in Java
        BigDecimal product = twentyOne.multiply(twentyOne);
        // multiplying BigDecimal of same scale

        BigDecimal multiplication = twentyOne.multiply(_22);
        // multiplying BigDecimal of different scale
        System.out.printf("product of %s and %s is %s %n", twentyOne,
                twentyTwo, product);
        System.out.printf("multiplication of %s and %s is %s %n",
                twentyOne, _22, multiplication);


        // Divide two BigDecimal in Java
        BigDecimal two = new BigDecimal("2.0");
        BigDecimal divide = twentyOne.divide(two); // dividing BigDecimal of same scale
        BigDecimal division = _22.divide(two);  // dividing BigDecimal of different scale
        System.out.printf("divide of %s and %s is %s %n", twentyOne, two, divide);
        System.out.printf("division of %s and %s is %s %n", _22, two, division);
    }
}
