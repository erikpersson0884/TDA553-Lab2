package Vehicles;


import java.awt.Color;
import java.math.BigDecimal;

import Utility.Positionable;


public abstract class Vehicle extends Positionable implements Movable, IVehicle {
    // Instance variables
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    // Constructor
    public Vehicle(String modelName, double enginePower, Color color, int nrDoors, double x, double y) {
        super(x, y, 0);
        this.modelName = modelName;
        this.enginePower = enginePower;
        this.color = color;
        this.nrDoors = nrDoors;

        stopEngine();
    }

    // Getters and Setters
    @Override
    public double getEnginePower() {
        return enginePower;
    }

    
    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }


    private void setCurrentSpeed(double newSpeed) {
        currentSpeed = newSpeed;
    }

    public String getModelName() {
        return modelName;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    // Methods for changing the speed of a car

    // Methods from the Movable interface.
    @Override
    public void move() {
        // x and y gets set based on current speed and coordinate, but also the angle
        // according to the current direction
        double changeInX = Math.cos(Math.toRadians(getDirection())) * getCurrentSpeed();
        double changeInY = Math.sin(Math.toRadians(getDirection())) * getCurrentSpeed();

        BigDecimal newX = getX().add(BigDecimal.valueOf(changeInX));
        BigDecimal newY = getY().add(BigDecimal.valueOf(changeInY));

        setX(newX);
        setY(newY);
    }

    @Override
    public void turnLeft() {
        // Turning left means we go 45 degrees to the left in the unit circle
        double newDirection = (getDirection() + 45) % 360;
        setDirection(newDirection);
    }

    @Override
    public void turnRight() {
        // Turning right means we go 45 degrees to the right in the unit circle
        double newDirection = (getDirection() - 45) % 360;
        setDirection(newDirection);
    }

    protected abstract double speedFactor();

    private double calcNewIncreasedSpeed(double amount) {
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;
        return newSpeed;
    }

    private boolean newIncreasedSpeedIsValid(double newSpeed) {
        boolean speedIsIncreasing = newSpeed >= getCurrentSpeed();
        boolean speedIsNotTooHigh = newSpeed <= getEnginePower();
        return speedIsIncreasing && speedIsNotTooHigh;
    }

    private double calcNewDecreasedSpeed(double amount) {
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        return newSpeed;
    }

    private boolean newDecreasedSpeedIsValid(double newSpeed) {
        boolean speedIsIncreasing = newSpeed <= getCurrentSpeed();
        boolean speedIsNotNegative = 0 <= newSpeed;
        return speedIsIncreasing && speedIsNotNegative;
    }

    private void incrementSpeed(double amount) {
        double newSpeed = calcNewIncreasedSpeed(amount);
        boolean validSpeed = newIncreasedSpeedIsValid(newSpeed);

        if (validSpeed)
            setCurrentSpeed(newSpeed);
    }

    private void decrementSpeed(double amount) {
        double newSpeed = calcNewDecreasedSpeed(amount);
        boolean validSpeed = newDecreasedSpeedIsValid(newSpeed);

        if (validSpeed)
            setCurrentSpeed(newSpeed);
    }

    @Override
    public void gas(double amount){
        // Can only gas between 0 and 1
        if (0 <= amount && amount <= 1){
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Only values in range [0-1] are accepted.");
        }
    }

    @Override
    public void brake(double amount) {
        // Can only brake between 0 and 1
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Only values in range [0-1] are accepted.");
        }
    }
}
