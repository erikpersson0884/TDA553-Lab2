package Ramps;

public class TransporterRamp extends Ramp {

    public TransporterRamp() {
        super(0);
    }

    @Override
    public boolean rampIsInCorrectPosistionWhenMoving() {
        return !this.getRampIsDown();
    }
    
}
