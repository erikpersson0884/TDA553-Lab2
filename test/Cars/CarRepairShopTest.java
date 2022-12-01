package Cars;


import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Buildings.CarRepairShop;
import CustomExceptions.*;
import Vehicles.Cars.Car;
import Vehicles.Cars.Volvo240;

public class CarRepairShopTest {
    private CarRepairShop carRepairShop;

    @Before
    public void createTestCarRepairShop() {
        carRepairShop = new CarRepairShop(4, 0, 90, 10);
    }

    @After
    public void removeTestCarRepairShop() {
        // Garbage collector deletes
        carRepairShop = null;
    }

    @Test
    public void cant_load_car_that_is_already_in_carRepairShop() {
        Volvo240 myVolvo = new Volvo240(0, null, 0, 0);
    
        assertThrows(CarIsAlreadyLoadedException.class, () -> {  
            carRepairShop.loadCar(myVolvo);  
            carRepairShop.loadCar(myVolvo);
        });
    }

    @Test 
    public void cannot_unload_car_thats_not_in_repairShop(){
        Car myVolvo = new Volvo240(33, Color.blue, 10, 6);

        carRepairShop.loadCar(myVolvo);
        carRepairShop.unloadCar(myVolvo);
        
        assertThrows(CarIsNotLoadedException.class, () -> {
            carRepairShop.unloadCar(myVolvo);
        });

    }

    
    @Test
    public void car_gets_coordinates_when_unloaded() {
        Car myVolvo = new Volvo240(33, Color.blue, 10, 6);

        carRepairShop.loadCar(myVolvo);
        carRepairShop.unloadCar(myVolvo);

        assertTrue(!((myVolvo.getX() == null) && (myVolvo.getY() == null)));
    }

    @Test
    public void loading_car_to_carRepairShop_when_it_is_full_should_not_add_the_car() {
        int ToManyCarsToLoad = carRepairShop.getMaxCapacity() + 5;

        assertThrows(CarStorageFullException.class, () -> {
            for (int i=0; i < ToManyCarsToLoad; i++) {
                carRepairShop.loadCar( new Volvo240(0, null, 0, 0));
            }
        });
        
    }

}
