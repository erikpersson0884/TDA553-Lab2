package Vehicles.Trucks;

import java.awt.Color;

import Ramps.Ramp;
import Vehicles.Vehicle;

public class Truck extends Vehicle {
    private Ramp ramp;

    public Truck(String modelname, double enginePower, Color color, int nrDoors, double x, double y, int maxAngle, Ramp ramp) {
        super(modelname, enginePower, color, nrDoors, x, y);
        this.ramp = ramp;
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    // Methods for changing the speed of a Truck
    public void gas(double amount) {
        // Can only gas between 0 and 1
        if (!(0 <= amount && amount <= 1)) {
            throw new IllegalArgumentException("Only values in range [0-1] are accepted.");
        } else if (getRamp().rampIsInCorrectPosistionWhenMoving()) {
            incrementSpeed(amount);
        }
    }

    public Ramp getRamp() {
        return ramp;
    }

    // Sets ramp to its highest position which is the maxAngle.
    public void raiseRampToMax() {
        if (getCurrentSpeed() == 0)
            ramp.raiseRampToMax();
    }

    // Sets ramp to its lowest position which is 0.
    public void lowerRampToMin() {
        if (getCurrentSpeed() == 0)
            ramp.lowerRampToMin();
    }
}