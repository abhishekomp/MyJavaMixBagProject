**Working with NULL**

1. Checking for null using Annotations
2. Using Null Object pattern
3. Using Optional
Note: var obj = null;   --this won't compile
   
**Checking for null using Assertion**

Example:
public boolean isBookReadyForPublication(Book book) {
    assert book != null : "Book is null";   //Book is null will be thrown if expression evaluates false
}
Java ignores assertions. They must be enabled using either -Enabled Assertions command line argument or using -ea 

**java.util.Objects (from Java 7)**

A class with helper methods
