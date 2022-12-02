package Ramps;

public abstract class Ramp {
    private RampState rampStateWhenDriving;
    private int rampAngle;
    private final int MAX_ANGLE;
    private final int MIN_ANGLE;
    private RampState rampState;

    public Ramp(int MAX_ANGLE, RampState rampStateWhenDriving) {
        this.MAX_ANGLE = MAX_ANGLE;
        this.MIN_ANGLE = 0;
        this.rampAngle = 0;
        this.rampStateWhenDriving = rampStateWhenDriving;
        this.rampState = rampStateWhenDriving;
    }
    private void setRampState(RampState newRampState){
        rampState = newRampState;
    }
    private RampState getRampState() {
        return rampState;
    }

    public int getMaxAngle() {
        return this.MAX_ANGLE;
    }

    public int getMinAngle() {
        return this.MIN_ANGLE;
    }

    public int getRampAngle() {
        return rampAngle;
    }

    private void setRampAngle(int newAngle) {
        rampAngle = newAngle;
    }

    // raise ramp from current position, can only between [0-70].

    public void raiseRamp(int degrees) {
        ensureDegreesIsValidRange(degrees);

        int newAngle = getRampAngle() + degrees;
        if (newAngle <= MAX_ANGLE) {
            setRampAngle(newAngle);
        }

        setRampState(RampState.UP);
    }

    // lower ramp from current position, can only between [0-70].
    public void lowerRamp(int degrees) {
        ensureDegreesIsValidRange(degrees);

        int newAngle = getRampAngle() - degrees;

        if (MIN_ANGLE < degrees && newAngle >= MIN_ANGLE) {
            setRampAngle(newAngle);
        }

        if (getRampAngle() == MIN_ANGLE) {
        setRampState(RampState.DOWN);
        }
    }

    public void raiseRampToMax() {
        rampAngle = MAX_ANGLE;
        setRampState(RampState.UP);
    }

    public void lowerRampToMin() {
        rampAngle = MIN_ANGLE;
        setRampState(RampState.DOWN);
    }

    private void ensureDegreesIsValidRange(int degrees) {
        if (degrees < MIN_ANGLE || degrees > MAX_ANGLE) {
            throw new IllegalArgumentException("Degrees must be in the interval [0-maxAngle]");
        }
    }

    public boolean rampIsInDrivingPosition() {
        getRampState();
        if (getRampState() == rampStateWhenDriving){
            return true;
        } else {
            return false;
        }
    }
    
}