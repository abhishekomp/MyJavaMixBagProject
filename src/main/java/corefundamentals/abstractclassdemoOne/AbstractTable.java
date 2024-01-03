package corefundamentals.abstractclassdemoOne;

//https://stackoverflow.com/questions/2371025/abstract-variables-in-java
public abstract class AbstractTable {

    protected String name;

    public AbstractTable(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

//    public static void main(String[] args) {
//        AbstractTable abstractTable = new AbstractTable();
//    }
}
