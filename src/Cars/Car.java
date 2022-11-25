package Cars;

import java.awt.*;
import java.math.BigDecimal;

public abstract class Car extends Vehicle {

    public Car(String modelName, double enginePower, Color color, int nrDoors, double x, double y) {
        super(modelName, enginePower, color, nrDoors, x, y);
    }

    public void gas(double amount) {
        // Can only gas between 0 and 1
        if (0 <= amount && amount <= 1) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Only values in range [0-1] are accepted.");
        }
    }

    public void loadCar(){
        setX(null);
        setY(null);
    }

    public void setCoordsForUnloadedCar(BigDecimal transporterX, BigDecimal transporterY) {
        BigDecimal spaceFromTransporter = new BigDecimal(20);
        setX(transporterX.add(spaceFromTransporter));
        setY(transporterY.add(spaceFromTransporter));
    }
}
