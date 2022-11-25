package Cars;
import Ramps.*;

import java.awt.Color;

import Ramps.TransporterRamp;

public class Transporter extends Truck {
    
    private TransporterRamp ramp;

    public Transporter(double enginePower, Color color, double x, double y){
        super("Car Transporter", enginePower, color, 2, x, y);
        this.ramp = new TransporterRamp();
    }

    @Override
    // Methods for changing the speed of a car
    public void gas(double amount){
        // Can only gas between 0 and 1
        if (!(0 <= amount && amount <= 1)){
            throw new IllegalArgumentException("Only values in range [0-1] are accepted.");
        } else if (ramp.rampIsUp() ){
            incrementSpeed(amount);
        }
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    public void raiseRamp(){
        if (getCurrentSpeed() == 0) 
            ramp.raiseRamp();
    }

    public void lowerRamp(){
        if (getCurrentSpeed() == 0) 
            ramp.lowerRamp();
    }
}
