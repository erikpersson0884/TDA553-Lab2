package Vehicles.Cars;
import java.awt.*;

import java.math.BigDecimal;


import Vehicles.Movable;


public class Saab95 implements ICar, Movable{
    private TurboCar turboCar;

    public Saab95(double enginePower, Color color, double x, double y) {
        this.turboCar = new TurboCar("Saab95", enginePower, color, 2, x, y);
    }

    @Override
    public void move() {
        turboCar.move();
    }

    @Override
    public void turnLeft() {
        turboCar.turnLeft();
    }

    @Override
    public void turnRight() {
        turboCar.turnRight();
    }

    @Override
    public void gas(double amount) {
        turboCar.gas(amount);
    }

    @Override
    public void brake(double amount) {
        turboCar.brake(amount);
    }


    public double getEnginePower() {
        return turboCar.getEnginePower();
    }


    public double getCurrentSpeed() {
        return turboCar.getCurrentSpeed();
    }

    @Override
    public BigDecimal getX() {
        return turboCar.getX();
    }

    @Override
    public BigDecimal getY() {
        return turboCar.getY();
    }

    @Override
    public void setCoordsForUnloadedCar(BigDecimal transporterX, BigDecimal transporterY) {
        turboCar.setCoordsForUnloadedCar(transporterX, transporterY);
    }
}
