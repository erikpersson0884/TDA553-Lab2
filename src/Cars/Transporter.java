package Cars;
import Ramps.*;

import java.awt.Color;

import Ramps.TransporterRamp;

public class Transporter extends Truck {
    
    private TransporterRamp ramp;

    public Transporter(double enginePower, Color color, double x, double y){
        super("Scania", enginePower, color, 2, x, y);
        this.ramp = new TransporterRamp();
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
