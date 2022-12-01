package Buildings;

import java.util.ArrayList;

import Utility.Positionable;
import Utility.CarStorage;
import Vehicles.Cars.Car;

public class CarRepairShop extends Positionable{
    private CarStorage carStorage;

    public CarRepairShop(double x, double y, double facingDirection, int maxCarCapacity) {
        super(x, y, facingDirection);
        carStorage = new CarStorage(maxCarCapacity, new ArrayList<Car>(), 30);
    }

    public int getMaxCapacity() {
        return carStorage.getMaxCapacity();
    }
        //--------  Methods for loading cars ----------

    public void loadCar(Car carToBeLoaded) {
        carStorage.loadCar(carToBeLoaded, this);
    }
    
    public void unloadCar(Car carToBeUnloaded){
        carStorage.unLoadCar(carToBeUnloaded, this);

    } 
}