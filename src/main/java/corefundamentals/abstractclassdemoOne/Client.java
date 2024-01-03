package corefundamentals.abstractclassdemoOne;

public class Client {
    public static void main(String[] args) {
        ConcreteTable woodenTable = new ConcreteTable("GoodTable");
        AbstractTable woodenTable2 = new ConcreteTable("NewGoodTable");
//        ConcreteTable woodenTableWontCompile = new ConcreteTable();
        //ConcreteTable woodenTableWithDefaultName = new ConcreteTable();
        System.out.println(woodenTable.getName());
        System.out.println(woodenTable2.getName());
//        System.out.println(woodenTableWontCompile.getName());
        //System.out.println(woodenTableWithDefaultName.getName());
    }
}
