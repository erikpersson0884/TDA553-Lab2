package Ramps;

public class TruckRamp extends Ramp {

    public TruckRamp() {
        super(70);
    }

    @Override
    public boolean rampIsInCorrectPosistionWhenMoving() {
        return this.getRampIsDown();
    }

}
