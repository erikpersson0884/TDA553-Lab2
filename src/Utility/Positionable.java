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

    private BigDecimal getBigDecimalX() {
        return x;
    }

    @Override
    public double getX() {
        return getBigDecimalX().doubleValue();
    }

    protected void setX(double x) {
        setX(BigDecimal.valueOf(x));
    }

    private void setX(BigDecimal x) {
        this.x = x;
    }

    private BigDecimal getBigDecimalY() {
        return y;
    }

    @Override
    public double getY() {
        return getBigDecimalY().doubleValue();
    }

    protected void setY(double y) {
        
        setY(BigDecimal.valueOf(y));
    }

    private void setY(BigDecimal y) {
        this.y = y;
    }

    protected double getDirection() {
        return direction;
    }

    protected void setDirection(double newDirection) {
        this.direction = newDirection;
    } 
}
