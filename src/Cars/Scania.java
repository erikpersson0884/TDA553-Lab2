package Cars;

import java.awt.Color;

import Ramps.TruckRamp;

public class Scania extends Truck {
    private TruckRamp ramp;
    
    public Scania(double enginePower, Color color, double x, double y){
        super("Scania", enginePower, color, 2, x, y);
        this.ramp = new TruckRamp();
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
    
    public void lowerRamp(int degrees){
        ramp.lowerRamp(degrees);
    }

    public int getRampAngle() {
        return ramp.getRampAngle();
    }

    // raises ramp according to degrees only if current speed is zero. 
    public void raiseRamp(int degrees){
        if (getCurrentSpeed() == 0) {
            ramp.raiseRamp(degrees);
        }
    }

    public void raiseRamp(){
        if (getCurrentSpeed() == 0)
            ramp.raiseRamp(70);
    }

    // when no argument is thrown sets 
    public void lowerRamp() {
        if (getCurrentSpeed() == 0)
            ramp.lowerRamp(0);
    }

}