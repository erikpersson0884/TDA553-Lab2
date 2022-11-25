package Ramps;

public class TruckRamp extends Ramp {
    private int rampAngle;
    
    public TruckRamp() {
        this.rampAngle = 0;
    }
       
    public int getRampAngle(){
        return rampAngle;
    }
    
    private void setRampAngle(int newAngle){
        rampAngle = newAngle;
    }

    // raise ramp from current position, can only between [0-70].

    public void raiseRamp(int degrees){
        ensureDegreesIsValidRange(degrees);
        setRampState("UP");

        int newAngle = getRampAngle() + degrees;
        if (newAngle <= 70) {
            setRampAngle(newAngle);
        }
    }

    // lower ramp from current position, can only between [0-70].
    public void lowerRamp(int degrees) {
        ensureDegreesIsValidRange(degrees);

        int newAngle = getRampAngle() - degrees;

        if  (0 < degrees && newAngle >= 0) {
            setRampAngle(newAngle);
        }
        
        if (getRampAngle() == 0) {
            setRampState("DOWN");
        } else {
            setRampState("UP");
        }
    }

     private void ensureDegreesIsValidRange(int degrees) {
        if (degrees < 0 || degrees > 70){
            throw new IllegalArgumentException("Degrees must be in the interval [0-70]");
        }
    }
}


   