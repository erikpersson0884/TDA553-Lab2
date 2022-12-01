package Vehicles;


public interface IVehicle {
    void gas(double amount);
    void brake(double amount);
    double getEnginePower();
    double getCurrentSpeed();

}
