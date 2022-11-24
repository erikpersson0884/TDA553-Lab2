package Cars;

public class TruckRamp implements Ramp {
    //private boolean RampIsUp;
    private int rampAngle;
    
    public TruckRamp() {
        this.rampAngle = 0;
    }

   
    public boolean rampIsDown() {
        if (rampAngle == 0) {
            return true;
        } else if (0 < rampAngle && rampAngle <= 70) {
            return false;
        } else {
            throw new IllegalArgumentException("RampAngle is not valid");
        }
    }  
    
    public int getRampAngle(){
        return rampAngle;
    }
    
    private void setRampAngle(int newAngle){
        rampAngle = newAngle;
    }

    // raise ramp from current position, can only between [0-70].
    @Override
    public void raiseRamp(int degrees){
        ensureDegreesIsValidRange(degrees);

        int newAngle = getRampAngle() + degrees;
        if (newAngle <= 70) {
            setRampAngle(newAngle);
        }
    }
    @Override
    // lower ramp from current position, can only between [0-70].
    public void lowerRamp(int degrees) {
        ensureDegreesIsValidRange(degrees);

        int newAngle = getRampAngle() - degrees;

        if  (0 < degrees && newAngle >= 0) {
            setRampAngle(newAngle);
        }
            
    }

     private void ensureDegreesIsValidRange(int degrees) {
        if (degrees < 0 || degrees > 70){
            throw new IllegalArgumentException("Degrees must be in the interval [0-70]");
        }
    }
}  