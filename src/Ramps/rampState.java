package Ramps;

public enum rampState {
    DOWN("down"),
    UP("up");

    private String currentRampState;

    private rampState(String theRampState){
        this.currentRampState = theRampState;
    }
    
    @Override
    public String toString() {
        return currentRampState;
    }
  }
  
