package Ramps;

public class TransporterRamp extends Ramp{
    @Override
    public boolean rampIsDown() {
        // TODO Auto-generated method stub
        return getRampState().equals("down");
    }

    @Override
    public boolean rampIsUp() {
        // TODO Auto-generated method stub
        return getRampState().equals("up");
    }
    
}

