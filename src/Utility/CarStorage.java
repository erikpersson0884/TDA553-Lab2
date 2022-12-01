package Utility;


import java.util.List;
import java.util.Stack;

import CustomExceptions.*;
import Vehicles.Cars.ICar;
import Vehicles.Cars.Volvo240;
import Vehicles.Cars.Car;

public class CarStorage implements ICarStorage {
    private int maxCapacity;
    private List<ICar> loadedCars;
    private int maxRangeForLoadingCars;

    public CarStorage(int maxCapacity, List<ICar> loadedCars, int maxRangeForLoadingCars) {
        this.maxCapacity = maxCapacity;
        this.loadedCars = loadedCars;
        this.maxRangeForLoadingCars = maxRangeForLoadingCars;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getMaxRangeForDetectingCars() {
        return maxRangeForLoadingCars;
    }

    @Override
    public void loadCar(ICar carToBeLoaded, Positionable currentPositionableObject) {

        if (loadedCars.size() >= maxCapacity) {
            throw new CarStorageFullException("The storage is full.");

        } else if (loadedCars.contains(carToBeLoaded)) {
            throw new CarIsAlreadyLoadedException("Car is already in storage");

        } else if (CarDetector.carIsInRange(carToBeLoaded, currentPositionableObject, maxRangeForLoadingCars)) {
            if (loadedCars instanceof Stack) {
                ((Stack<ICar>) loadedCars).push(carToBeLoaded);
            } else {
                loadedCars.add(carToBeLoaded);
            }
        }
    }

    @Override
    public void unLoadCar(ICar carToBeUnloaded, Positionable currentPositionableObject) {
        if (!loadedCars.contains(carToBeUnloaded)) {
            throw new CarIsNotLoadedException("The car is not loaded on the Transporter.");
        } else if (loadedCars instanceof Stack) {
            if ((((Stack<ICar>) loadedCars).lastElement() != carToBeUnloaded)) {
                throw new CarIsNotLastException("Car is not last");
            }      
                   
            ((Stack<ICar>) loadedCars).pop();
            carToBeUnloaded.setCoordsForUnloadedCar(currentPositionableObject.getY(), currentPositionableObject.getX());
        } else {
                loadedCars.remove(carToBeUnloaded);
                carToBeUnloaded.setCoordsForUnloadedCar(currentPositionableObject.getX(), currentPositionableObject.getY());
        } 
    }
}
