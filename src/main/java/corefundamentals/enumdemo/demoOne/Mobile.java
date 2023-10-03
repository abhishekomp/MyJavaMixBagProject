package corefundamentals.enumdemo.demoOne;

/**
 * Created by sca820 on 13 sep., 2022
 */
// enum showing Mobile prices
public enum Mobile {
    Samsung(400),
    Nokia(250),
    Motorola(325);

    int price;
    Mobile(int p) {
        price = p;
    }
    int showPrice() {
        return price;
    }
}
