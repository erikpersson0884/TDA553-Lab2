package Utility;


import Vehicles.Cars.Car;

public interface ICarStorage{
    void loadCar(Car carToBeLoaded, Positionable currentPositionableObject);
    void unLoadCar(Car carToBeUnloaded, Positionable currentPositionableObject);
}
