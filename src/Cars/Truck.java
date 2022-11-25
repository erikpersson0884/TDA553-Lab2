package Cars;
import Ramps.*;

import java.awt.Color;

public class Truck extends Car {
    private Ramp ramp;

    public Truck(String modelname, double enginePower, Color color, int nrDoors, double x, double y){
        super(modelname, enginePower, color, nrDoors, x, y);
        this.ramp = new TruckRamp();
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
    
    @Override
    // Methods for changing the speed of a car
    public void gas(double amount){
        // Can only gas between 0 and 1
        if (!(0 <= amount && amount <= 1)){
            throw new IllegalArgumentException("Only values in range [0-1] are accepted.");
        } else if (ramp.rampIsDown() ){
            incrementSpeed(amount);
        }
    }



}