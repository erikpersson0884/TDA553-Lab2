package Utility;


import java.math.BigDecimal;

public abstract class Positionable implements IPositionable {
    // Instance variables
    private BigDecimal x;
    private BigDecimal y;
    private double direction; // Direction (based on the unit circle)

    // Constructor
    private Positionable(double x, double y) {
        this.x = new BigDecimal(x);
        this.y = new BigDecimal(y);
    }
    public Positionable(double x, double y, double direction){
        this(x, y);
        this.direction = direction;
    }

    // Methods for getters and setters
    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }

    protected double getDirection() {
        return direction;
    }

    protected void setDirection(double newDirection) {
        this.direction = newDirection;
    } 
}
