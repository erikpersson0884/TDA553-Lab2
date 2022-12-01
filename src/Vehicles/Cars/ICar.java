package Vehicles.Cars;

import java.math.BigDecimal;

public interface ICar {
    public void setCoordsForUnloadedCar(BigDecimal transporterX, BigDecimal transporterY);
    BigDecimal getY();
    BigDecimal getX();
}
