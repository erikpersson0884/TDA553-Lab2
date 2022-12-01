package Vehicles.Cars;
import java.awt.*;

public class TrimCar extends Car {
    private final static double trimFactor = 1.25;

    public TrimCar(String name, double enginePower, Color color, int nrDoors, double x, double y){
        super(name, enginePower, color, nrDoors, x, y);
    }
    
    // Methods
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}