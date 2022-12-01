package Vehicles.Cars;
import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    // Constructor
    public Volvo240(double enginePower, Color color, double x, double y){
        super("Volvo240", enginePower, color, 4, x, y);
    }
    
    // Methods
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
    
}