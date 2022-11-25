package Cars;

import java.awt.Color;

public class Truck extends Car {
    public Truck(String modelname, double enginePower, Color color, int nrDoors, double x, double y){
        super(modelname, enginePower, color, nrDoors, x, y);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
}