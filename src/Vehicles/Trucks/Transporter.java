package Vehicles.Trucks;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Stack;

import CustomExceptions.*;
import Ramps.TransporterRamp;
import Utility.CarStorage;
import Utility.IPositionable;
import Vehicles.Movable;
import Vehicles.Cars.ICar;

public class Transporter implements Movable, IPositionable {
    private Truck truck;
    private int maxAngle;

    private CarStorage carStorage;

    public Transporter(double enginePower, Color color, double x, double y) {
        maxAngle = 0;
        truck = new Truck("transporter", enginePower, color, 0, x, y, maxAngle, new TransporterRamp());
        carStorage = new CarStorage(7, new Stack<ICar>(), 30);
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

    public void move() {
        truck.move();
    }

    public void turnLeft() {
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

    public void raiseRamp() {
        truck.raiseRampToMax();
    }

    public void lowerRamp() {
        truck.lowerRampToMin();
    }

    // ----------- methods with own implementation ---------

    public void gas(double amount) {
        truck.gas(amount);
    }

    // -------- Methods for loading cars ----------

    public void loadCar(ICar carToBeLoaded) {
        carStorage.loadCar(carToBeLoaded, truck);

        if (!getRampIsDown()) {
            throw new RampIsNotDownException("The transporters' ramp is not down");
        }
    }

    public void unLoadCar(ICar carToBeUnloaded) {
        if (!getRampIsDown()) {
            throw new RampIsNotDownException("The transporters' ramp is not down");
        }
        carStorage.unLoadCar(carToBeUnloaded, truck);
    }
}