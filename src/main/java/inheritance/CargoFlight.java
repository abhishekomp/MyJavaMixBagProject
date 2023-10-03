package inheritance;

public class CargoFlight extends Flight{
    int seats;
    float maxCargoSpace = 1000.0f;
    float usedCargoSpace;

    public CargoFlight(int seats) {
        this.seats = seats;
    }

    public void add1Package(float l, float w, float h) {
        float size = l * w * h;
        if(hasCargoSpace()) {
            usedCargoSpace = usedCargoSpace + size;
        }
        else {
            hasNoCargoSpace();
        }
    }

    private void hasNoCargoSpace() {
        System.out.println("Insufficient Cargo space");
    }

    private boolean hasCargoSpace() {
        return maxCargoSpace > usedCargoSpace;
    }
}
