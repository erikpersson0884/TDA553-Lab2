package Vehicles.Cars;
import java.awt.*;


public class Saab95 extends Car{
    
    private boolean turboOn;

    
    public Saab95(double enginePower, Color color, double x, double y){
        super("Saab95", enginePower, color, 2, x, y);
	    turboOn = false;
    }
    
    // Methods

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        
        return getEnginePower() * 0.01 * turbo;
    }
}
