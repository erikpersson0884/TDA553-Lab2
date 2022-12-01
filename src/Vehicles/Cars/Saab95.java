package Vehicles.Cars;
import java.awt.*;

import java.math.BigDecimal;


import Utility.IPositionable;
import Vehicles.Movable;


public class Saab95 implements ICar, Movable, IPositionable {
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

  
    public void gas(double amount) {
        turboCar.gas(amount);
    }

 
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
        // TODO Auto-generated method stub
        
    }
}
