package Vehicles.Trucks;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Stack;

import CustomExceptions.*;
import Utility.CarStorage;
import Vehicles.Cars.Car;
import Vehicles.Trucks.Truck;
import Vehicles.Vehicle;

public class Transporter{
  
    private Truck truck;
    private int maxAngle;

    private CarStorage carStorage;

    public Transporter(double enginePower, Color color, double x, double y){
        maxAngle = 0;
        truck = new Truck("transporter", enginePower, color, 0, x, y, maxAngle);
        carStorage = new CarStorage(7, new Stack<Car>(), 30);
    }
    
    // ------------ delegated methods -------------

    public double getCurrentSpeed() {
        return truck.getCurrentSpeed();
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
    public boolean getRampIsDown() {
        return truck.getRamp().getRampIsDown();
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

    public void brake(double amount) {
        truck.brake(amount);
    }

    protected double getSpeedFactor() {
        return truck.speedFactor();
    }

    public void raiseRamp(){
            truck.raiseRampToMax();
    }

    public void lowerRamp(){
            truck.lowerRampToMin();
    }

    // ----------- methods with own implementation ---------
    
    public void gas(double amount) {
        // Can only gas between 0 and 1
        if (!(0 <= amount && amount <= 1)) {
            throw new IllegalArgumentException("Only values in range [0-1] are accepted.");
        } else if (!truck.getRamp().getRampIsDown()) {
            truck.incrementSpeed(amount);
        }
    }

    //--------  Methods for loading cars ----------

    public void loadCar(Car carToBeLoaded) {
        carStorage.loadCar(carToBeLoaded, truck);

        if (!getRampIsDown()) {
            throw new RampIsNotDownException("The transporters' ramp is not down");

        }
    }

    public void unloadCar(Car carToBeUnloaded){
        if (!getRampIsDown()) {
            throw new RampIsNotDownException("The transporters' ramp is not down");
        }
        carStorage.unLoadCar(carToBeUnloaded, truck);
    }
}