package Ramps;

public class TransporterRamp {
    private boolean isDown;

    public TransporterRamp() {
        this.isDown = false;
    }

    public boolean getRampState(){
        return isDown;
    }
    
    public void raiseRamp() {
        isDown = false;
    }

    public void lowerRamp() {
        isDown = true;
    }


}
