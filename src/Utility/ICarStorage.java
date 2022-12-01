package Utility;

import Vehicles.Cars.ICar;

public interface ICarStorage{
    void loadCar(ICar carToBeLoaded, Positionable currentPositionableObject);
    void unLoadCar(ICar carToBeUnloaded, Positionable currentPositionableObject);
}
