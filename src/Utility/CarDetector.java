package Utility;


import Vehicles.Cars.Car;

public class CarDetector {
    /** Detects if a Car object is nearby a Positionable object according to the specified distance. 
     * @param carToBeDetected
     * @param currentPositionableObject
     * @param maxRangeForDetectingCars
     * @return boolean
     */
    public static boolean carIsInRange(Car carToBeDetected, Positionable currentPositionableObject, int maxRangeForDetectingCars) {
        double carX = carToBeDetected.getX().doubleValue();
        double carY = carToBeDetected.getY().doubleValue();

        double currentPositionableObjectX = currentPositionableObject.getX().doubleValue();
        double ccurrentPositionableObjectY= currentPositionableObject.getY().doubleValue();

        boolean carXIsInRange = (carX <= currentPositionableObjectX + maxRangeForDetectingCars 
                                && carX >= currentPositionableObjectX - maxRangeForDetectingCars);
        boolean carYIsInRange = (carY <= ccurrentPositionableObjectY + maxRangeForDetectingCars 
                                && carY >= ccurrentPositionableObjectY - maxRangeForDetectingCars);
        boolean carIsInRange = carXIsInRange && carYIsInRange;
        
        return carIsInRange;
    }   
}

