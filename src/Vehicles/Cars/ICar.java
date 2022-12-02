package Vehicles.Cars;

import java.math.BigDecimal;

import Vehicles.IVehicle;

public interface ICar extends IVehicle {
    public void setCoordsForUnloadedCar(BigDecimal transporterX, BigDecimal transporterY);
}
