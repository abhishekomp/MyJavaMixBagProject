package workingwithclassesinheritance;

public class Main {
    public static void main(String[] args) {
//        Adder adder = new Adder();
//        doCalculation(adder, 100.9, 50.0);
//
//        Substractor substractor = new Substractor();
//        doCalculation(substractor, 100.9, 50.0);
//
//        Divider divider = new Divider();
//        doCalculation(divider, 100.0d, 50.0d);


        //performMoreCalculations();

        executeUsingEnums();
    }

    private static void executeUsingEnums() {
        final CalculateBase calculation = createCalculation("ADD", 10, 20);
        calculation.calculate();
        System.out.println("Result = " + calculation.getResult());
    }

    private static CalculateBase createCalculation(String operation, double leftVal, double rightVal) {
        CalculateBase calculateBase = null;
        switch (MathOperation.valueOf(operation)) {
            case ADD:
                calculateBase = new Adder(leftVal, rightVal);
                break;

        }
        return  calculateBase;
    }

    private static void performMoreCalculations() {
        CalculateBase[] calculations = {
                new Adder(100.2,200.3),
                new Substractor(100.2,50.2),
                new Multiplier(10,85),
                new Divider(100,2)
        };

        for(CalculateBase calculateBase : calculations) {
            calculateBase.calculate();
            System.out.println("calculateBase.getResult() = " + calculateBase.getResult());
        }
    }

    static void doCalculation(CalculateBase calculation, double leftVal, double rightVal) {
        calculation.setLeftVal(leftVal);
        calculation.setRightVal(rightVal);
        calculation.calculate();
        System.out.println("Calculation result = " + calculation.getResult());
    }

}
