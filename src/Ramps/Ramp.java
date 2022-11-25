package Ramps;

public abstract class Ramp {

    private rampState theRampState;
    
    public Ramp(){
        this.theRampState = rampState.DOWN;
    }

    public void setRampState(String newRampState) {
        theRampState = rampState.valueOf(newRampState);
    }

    public String getRampState() {
        return theRampState.name();
    }

    public boolean rampIsDown() {
        return getRampState().equals("DOWN");
    }

    public boolean rampIsUp() {
        return getRampState().equals("UP");
    }

    public void raiseRamp() {
        setRampState("UP");
    }

    public void lowerRamp() {
        setRampState("DOWN");
    }
}  