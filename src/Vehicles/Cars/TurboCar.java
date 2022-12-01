package Vehicles.Cars;
import java.awt.*;

public class TurboCar extends Car{
    private boolean turboOn;

    public TurboCar(String name, double enginePower, Color color, int nrDoors, double x, double y){
        super(name, enginePower, color, nrDoors, x, y);
	    turboOn = false;
    }

    // Methods

    public void setTurboOff(){
	    turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        
        return getEnginePower() * 0.01 * turbo;
    }


    
}