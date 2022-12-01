package Cars;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Vehicles.Cars.Saab95;

public class Saab95Test {
    private Saab95 mySaab95;
    
    @Before 
    public void createTestSaab95(){
        mySaab95 = new Saab95(500, Color.red, 0, 0);
    }
    @After
    public void removeTestSaab95(){
        // Garbage collector deletes
        mySaab95 = null;
    }

    // Tests to do, gas, brake, currentSpeed, move, direction, turn left, turn right
    @Test
    public void gas_cannot_result_in_the_speed_decreasing(){
        double previousSpeed =  mySaab95.getCurrentSpeed();
        mySaab95.gas(1);
        assertFalse(previousSpeed > mySaab95.getCurrentSpeed());
    }

    @Test
    public void gas_cannot_take_in_value_below_zero(){
        assertThrows(IllegalArgumentException.class, () -> {          
            mySaab95.gas(-1);  
        });
    }
    @Test
    public void brake_cannot_result_in_the_speed_increasing(){   
        mySaab95.gas(0.5);
        double previousSpeed =  mySaab95.getCurrentSpeed();
        mySaab95.brake(0.1);

        assertFalse(previousSpeed < mySaab95.getCurrentSpeed());
    }

    @Test
    public void brake_cannot_take_in_value_above_one(){
        assertThrows(IllegalArgumentException.class, () -> {          
            mySaab95.brake(2);
        });
    }

    @Test 
    public void car_speed_cannot_be_higher_than_enginePower(){
        for (int i = 0; i < 100; i++){
            mySaab95.gas(1);
        }
       
        assertFalse(mySaab95.getEnginePower() <  mySaab95.getCurrentSpeed());
    }

    @Test 
    public void car_speed_cannot_be_lower_than_0(){
        for (int i = 0; i < 100; i++) {
            mySaab95.brake(1);
        }

        assertFalse(mySaab95.getCurrentSpeed() < 0);
    }

    @Test
    public void moving_and_turning_the_car_to_its_original_position_should_result_in_its_original_position() {
        BigDecimal prevX = mySaab95.getX();
        BigDecimal prevY = mySaab95.getY();

        mySaab95.gas(0.5);

        mySaab95.turnRight();

        mySaab95.move();

        for (int i = 0; i < 4; i ++){
            mySaab95.turnLeft();
        }
        
        mySaab95.move();
        
        assertTrue(BigDecimal.ZERO.equals(prevX) && BigDecimal.ZERO.equals(prevY));

    }

}
