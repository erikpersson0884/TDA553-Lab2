package Cars;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Stack;
import CustomExceptions.*;

public class Transporter{
  
    private Truck truck;
    private int maxAngle;
    private int maxNumberOfCars;
    private Stack<Car> loadedCars;
    private int maxRangeForLoadingCars;
    //private Ramp ramp;

    public Transporter(double enginePower, Color color, double x, double y){
        maxAngle = 0;
        truck = new Truck("transporter", enginePower, color, 0, x, y, maxAngle);
        //public setter for coordinates thing
        loadedCars = new Stack<Car>();
        maxNumberOfCars = 7;
        maxRangeForLoadingCars = 30;
    }
    
    // ------------ delegated methods -------------

    public double getCurrentSpeed() {
        return truck.getCurrentSpeed();
    }

    public double getEnginePower() {
        return truck.getEnginePower();
    }
    
    public BigDecimal getX() {
        return truck.getX();
    }

    public BigDecimal getY() {
        return truck.getY();
    }
    public boolean getRampIsDown() {
        return truck.getRamp().getRampIsDown();
    }
    public void move(){
        truck.move();
    }

    public void turnLeft(){
        truck.turnLeft();
    }
    
    public void turnRight() {
        truck.turnRight();
    }

    public void brake(double amount) {
        truck.brake(amount);
    }

    protected double getSpeedFactor() {
        return truck.speedFactor();
    }

    public void raiseRamp(){
            truck.raiseRampToMax();
    }

    public void lowerRamp(){
            truck.lowerRampToMin();
    }

    // ----------- methods with own implementation ---------
    
    public void gas(double amount) {
        // Can only gas between 0 and 1
        if (!(0 <= amount && amount <= 1)) {
            throw new IllegalArgumentException("Only values in range [0-1] are accepted.");
        } else if (!truck.getRamp().getRampIsDown()) {
            truck.incrementSpeed(amount);
        }
    }

    //--------  Methods for loading cars ----------

    public void loadCar(Car carToBeLoaded) {

        if (!getRampIsDown()) {
            throw new RampIsNotDownException("The transporters' ramp is not down");

        } else if (loadedCars.size() >= maxNumberOfCars) {
            throw new TransporterFullException("The transporter is full.");
            
        } else if (loadedCars.contains(carToBeLoaded)) {
            throw new CarIsAlreadyLoadedException("Car is already on Transporter");

        } else if (carIsInRange(carToBeLoaded)) {
            carToBeLoaded.loadCar();
            loadedCars.push(carToBeLoaded);
        }
    }

    public void unloadCar(Car carToBeUnloaded){
        if (!getRampIsDown()) {
            throw new RampIsNotDownException("The transporters' ramp is not down");
        } else if (!loadedCars.contains(carToBeUnloaded)) {
            throw new CarIsNotLoadedException("The car is not loaded on the Transporter.");
        } else if (loadedCars.lastElement() == carToBeUnloaded) {
            loadedCars.pop();
            carToBeUnloaded.setCoordsForUnloadedCar(getY(), getX());
        } 
    }

    private boolean carIsInRange(Car carToBeLoaded) {
        double carX = carToBeLoaded.getX().doubleValue();
        double carY = carToBeLoaded.getY().doubleValue();

        double transporterX = this.getX().doubleValue();
        double transporterY = this.getY().doubleValue();

        boolean carXIsInRange = (carX <= transporterX + maxRangeForLoadingCars && carX >= transporterX - maxRangeForLoadingCars);
        boolean carYIsInRange = (carY <= transporterY + maxRangeForLoadingCars && carY >= transporterY - maxRangeForLoadingCars);
        boolean carIsInRange = carXIsInRange && carYIsInRange;
        
        return carIsInRange;
    }
}