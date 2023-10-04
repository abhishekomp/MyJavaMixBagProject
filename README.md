# Collectors, groupingBy, Sorting a Map, collectingAndThen
- Example code: src/main/java/java8practice/PersonDemoJava8.java
- Example Code: src/test/java/java8practice/Java8LambdaAndStream.java
- Static import for using groupingBy, mapping: import static java.util.stream.Collectors.*;
- groupingBy creates a bucket depending upon the function.
- groupingBy can have a mapping as well so that instead of putting the incoming object it extracts some minute details from the object and puts it into the bucket.
- groupingBy along with mapping requires you to specify toList() as well.
- groupingBy assumes you want a list and hence you need not specify toList for groupingBy
- groupingBy can also take counting() collector so that while it is grouping by the function, it puts the count in the bucket
    For example, given a list of person give me a map with key as person name and count of all persons with that name
    So in here we will have the key as name of the person and value as the count of persons with that name.
    Note: This returns a map with value as Long by default.
- mapToInt and then sum() to get the sum of all integer values. sum() returns an integer value in this case.
- mapToInt and then max() will return an Optional. Why did sum not return an optional. It is because the sum is defined as 0 if the collection is empty.
- mapToInt and then min() will return an Optional. Why did sum not return an optional. It is because the sum is defined as 0 if the collection is empty.
- maxBy() and comparing(). maxBy takes a comparator. import static java.util.Comparator.comparing;
    maxBy() will return an Optional of the object.
- 

# Collectors scenario


# DecimalFormat
**Some Content**
https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html
https://stackoverflow.com/questions/5236056/force-point-as-decimal-separator-in-java
https://stackoverflow.com/questions/5054132/how-to-change-the-decimal-separator-of-decimalformat-from-comma-to-dot-point
