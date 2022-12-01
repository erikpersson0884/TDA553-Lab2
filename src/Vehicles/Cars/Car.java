package Vehicles.Cars;

import java.awt.*;
import java.math.BigDecimal;

import Vehicles.Vehicle;

public abstract class Car extends Vehicle implements ICar {

    public Car(String modelName, double enginePower, Color color, int nrDoors, double x, double y) {
        super(modelName, enginePower, color, nrDoors, x, y);
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
