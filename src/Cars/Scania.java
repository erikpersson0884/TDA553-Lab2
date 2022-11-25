package Cars;

import java.awt.Color;
import java.math.BigDecimal;

public class Scania{
    //private Ramp ramp;
    private Truck truck;
    private int maxAngle;

    public Scania(double enginePower, Color color, double x, double y){
        this.maxAngle= 70;
        this.truck = new Truck("Scania", enginePower, color, 2, x, y, maxAngle);
    }

    // --------- delegated methods -----------------

    public double getCurrentSpeed() {
        return truck.getCurrentSpeed();
    }

    public void brake(double amount) {
        truck.brake(amount);
    }

    public double getEnginePower() {
        return truck.getEnginePower();
    }
    
    public BigDecimal getX() {
        return truck.getX();
    }

    public BigDecimal getY() {
        return truck.getY();
    }

    public void move(){
        truck.move();
    }

    public void turnLeft(){
        truck.turnLeft();
    }
    
    public void turnRight() {
        truck.turnRight();
    }


 
    /**
        Method for increasing speed for a Scania Truck. 
        @param amount
     */
    public void gas(double amount) {
        truck.gas(amount);
    }

    // -------- Methods with own implementation ------------

    public int getRampAngle() {
        return truck.getRamp().getRampAngle();
    }
    
    // raises ramp according to degrees only if current speed is zero. 
    public void raiseRamp(int degrees){
        if (getCurrentSpeed() == 0) {
            truck.getRamp().raiseRamp(degrees);
        }
    }

    public void lowerRamp(int degrees){
        truck.getRamp().lowerRamp(degrees);
    }

    public void raiseRampToMax(){
        if (getCurrentSpeed() == 0)
            truck.getRamp().raiseRamp(truck.getRamp().getMaxAngle());
    }

    // when no argument is thrown sets 
    public void lowerRampToMin() {
        if (getCurrentSpeed() == 0)
            truck.getRamp().lowerRamp(truck.getRamp().getMinAngle());
    }
}
