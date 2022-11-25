package Cars;

import java.util.Arrays;
import java.util.List;

import CustomExceptions.*;

public class CarRepairShop extends Positionable{

    private int maxCapacity;
    private List<Car> loadedCars;
    private int maxRangeForLoadingCars;

    public CarRepairShop(double x, double y, double facingDirection, int maxCarCapacity) {
        super(x, y, facingDirection);
        maxCapacity = maxCarCapacity;
        maxRangeForLoadingCars = 30;
        loadedCars = Arrays.asList(new Car[maxCarCapacity]);
    }
        //--------  Methods for loading cars ----------

    public void loadCar(Car carToBeLoaded) {
        if (loadedCars.size() >= maxCapacity) {
            throw new TransporterFullException("The shop is full.");
            
        } else if (loadedCars.contains(carToBeLoaded)) {
            throw new CarIsAlreadyLoadedException("Car is already in the shop");

        } else if (carIsInRange(carToBeLoaded)) {
            carToBeLoaded.loadCar();
            loadedCars.add(carToBeLoaded);
        }
    }
    
    public void unloadCar(Car carToBeUnloaded){
        if (!loadedCars.contains(carToBeUnloaded)) {
            throw new CarNotOnTransporterException("The car is not in the shop.");
        } else {
            loadedCars.remove(carToBeUnloaded);
            carToBeUnloaded.setCoordsForUnloadedCar(getY(), getX());
        } 
    }

    // the same...
    private boolean carIsInRange(Car carToBeLoaded) {
        double carX = carToBeLoaded.getX().doubleValue();
        double carY = carToBeLoaded.getY().doubleValue();

        double shopX = this.getX().doubleValue();
        double shopY = this.getY().doubleValue();

        boolean carXIsInRange = (carX <= shopX + maxRangeForLoadingCars && carX >= shopX - maxRangeForLoadingCars);
        boolean carYIsInRange = (carY <= shopY + maxRangeForLoadingCars && carY >= shopY - maxRangeForLoadingCars);
        boolean carIsInRange = carXIsInRange && carYIsInRange;
        
        return carIsInRange;
    }   
}