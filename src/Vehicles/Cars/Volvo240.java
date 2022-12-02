package Vehicles.Cars;

import java.awt.*;
import java.math.BigDecimal;

import Vehicles.Movable;

public class Volvo240 implements ICar, Movable {

    private TrimCar trimCar;

    // Constructor
    public Volvo240(double enginePower, Color color, double x, double y) {
        trimCar = new TrimCar("Volvo240", enginePower, color, 4, x, y);
    }

    @Override
    public void move() {
        trimCar.move();
    }

    @Override
    public void turnLeft() {
        trimCar.turnLeft();
    }

    @Override
    public void turnRight() {
        trimCar.turnRight();
    }

    @Override
    public void gas(double amount) {
        trimCar.gas(amount);
    }

    @Override
    public void brake(double amount) {
        trimCar.brake(amount);
    }

    public double getEnginePower() {
        return trimCar.getEnginePower();
    }

    public double getCurrentSpeed() {
        return trimCar.getCurrentSpeed();
    }

    @Override
    public BigDecimal getX() {
        return trimCar.getX();
    }

    @Override
    public BigDecimal getY() {
        return trimCar.getY();
    }

    @Override
    public void setCoordsForUnloadedCar(BigDecimal transporterX, BigDecimal transporterY) {
        trimCar.setCoordsForUnloadedCar(transporterX, transporterY);
    }

}