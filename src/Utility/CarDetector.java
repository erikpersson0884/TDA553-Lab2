package Utility;


import Vehicles.Cars.ICar;

class CarDetector {
    /** Detects if a Car object is nearby a Positionable object according to the specified distance. 
     * @param carToBeDetected
     * @param currentPositionableObject
     * @param maxRangeForDetectingCars
     * @return boolean
     */
    static boolean carIsInRange(ICar carToBeDetected, Positionable currentPositionableObject, int maxRangeForDetectingCars) {
        double carX = carToBeDetected.getX();
        double carY = carToBeDetected.getY();

        double currentPositionableObjectX = currentPositionableObject.getX();
        double ccurrentPositionableObjectY= currentPositionableObject.getY();

        boolean carXIsInRange = (carX <= currentPositionableObjectX + maxRangeForDetectingCars 
                                && carX >= currentPositionableObjectX - maxRangeForDetectingCars);
        boolean carYIsInRange = (carY <= ccurrentPositionableObjectY + maxRangeForDetectingCars 
                                && carY >= ccurrentPositionableObjectY - maxRangeForDetectingCars);
        boolean carIsInRange = carXIsInRange && carYIsInRange;
        
        return carIsInRange;
    }   
}

