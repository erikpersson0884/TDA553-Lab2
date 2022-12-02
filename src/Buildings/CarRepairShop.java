package Buildings;

import java.util.ArrayList;

import Utility.Positionable;
import Utility.CarStorage;
import Vehicles.Cars.ICar;

public class CarRepairShop extends Positionable {
    private CarStorage carStorage;

    public CarRepairShop(double x, double y, double facingDirection, int maxCarCapacity) {
        super(x, y, facingDirection);
        carStorage = new CarStorage(maxCarCapacity, new ArrayList<ICar>(), 30);
    }

    public int getMaxCapacity() {
        return carStorage.getMaxCapacity();
    }
    // -------- Methods for loading cars ----------

    public void loadCar(ICar carToBeLoaded) {
        carStorage.loadCar(carToBeLoaded, this);
    }

    public void unloadCar(ICar carToBeUnloaded) {
        carStorage.unLoadCar(carToBeUnloaded, this);

    }
}