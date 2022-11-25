package Cars;

public class Ramp {
    private int rampAngle;
    private boolean rampIsDown;
    private final int MAX_ANGLE;
    private final int MIN_ANGLE;

    public Ramp(int MAX_ANGLE) {
        this.MAX_ANGLE = MAX_ANGLE;
        this.MIN_ANGLE = 0;
        this.rampAngle = 0;
        this.rampIsDown = true;
    }

    public void setRampIsDown(boolean newRampState) {
        rampIsDown = newRampState;
    }
    
    public boolean getRampIsDown() {
        return rampIsDown;
    }
    // public boolean rampIsDown() {
        // if (rampAngle == 0) {
            // setRampIsDown(true);
            // return rampIsDown;
        // } else if (0 < rampAngle && rampAngle <= 70) {
            // setRampIsDown(false);
            // return rampIsDown;
        // } else {
            // throw new IllegalArgumentException("RampAngle is not valid");
        // }
    // }  
    public int getMaxAngle() {
        return this.MAX_ANGLE;
    }

    public int getMinAngle() {
        return this.MIN_ANGLE;
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

        int newAngle = getRampAngle() + degrees;
        if (newAngle <= MAX_ANGLE) {
            setRampAngle(newAngle);
        }

        setRampIsDown(true);
    }

    // lower ramp from current position, can only between [0-70].
    public void lowerRamp(int degrees) {
        ensureDegreesIsValidRange(degrees);

        int newAngle = getRampAngle() - degrees;

        if  (MIN_ANGLE < degrees && newAngle >= MIN_ANGLE) {
            setRampAngle(newAngle);
        }
        
        if (getRampAngle() == MIN_ANGLE) {
            setRampIsDown(true);
        }
    }

    public void raiseRampToMax() {
        rampAngle = MAX_ANGLE;
        rampIsDown = false;
    }

    public void lowerRampToMin() {
        rampAngle = MIN_ANGLE;
        rampIsDown = true;
    }

     private void ensureDegreesIsValidRange(int degrees) {
        if (degrees < MIN_ANGLE || degrees > MAX_ANGLE){
            throw new IllegalArgumentException("Degrees must be in the interval [0-maxAngle]");
        }
    }
}