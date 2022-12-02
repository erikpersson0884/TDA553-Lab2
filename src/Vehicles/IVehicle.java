package Vehicles;

import Utility.IPositionable;

public interface IVehicle extends IPositionable{
    void gas(double amount);
    void brake(double amount);
    double getEnginePower();
    double getCurrentSpeed();

}
