package Cars;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Vehicles.Cars.Volvo240;

public class Volvo240Test {
    private Volvo240 myVolvo;
    
    @Before
    public void createTestVolvo240(){
        myVolvo = new Volvo240(0, null, 0, 0);
    }

    @After
    public void removeTestVolvo240(){
        // Garbage collector deletes
        myVolvo = null;
    }

    // Tests to do, gas, brake, currentSpeed, move, direction, turn left, turn right
    @Test
    public void gas_cannot_result_in_the_speed_decreasing(){
        double previousSpeed =  myVolvo.getCurrentSpeed();
        myVolvo.gas(1);
        assertFalse(previousSpeed > myVolvo.getCurrentSpeed());
    }

    @Test
    public void gas_cannot_take_in_value_below_zero(){
        assertThrows(IllegalArgumentException.class, () -> {          
            myVolvo.gas(-1);  
        });
    }
    @Test
    public void brake_cannot_result_in_the_speed_increasing(){   
        myVolvo.gas(0.5);
        double previousSpeed =  myVolvo.getCurrentSpeed();
        myVolvo.brake(0.1);

        assertFalse(previousSpeed < myVolvo.getCurrentSpeed());
    }

    @Test
    public void brake_cannot_take_in_value_above_one(){
        assertThrows(IllegalArgumentException.class, () -> {          
            myVolvo.brake(2);
        });
    }

    @Test 
    public void car_speed_cannot_be_higher_than_enginePower(){
        for (int i = 0; i < 100; i++){
            myVolvo.gas(1);
        }
       
        assertFalse(myVolvo.getEnginePower() <  myVolvo.getCurrentSpeed());
    }

    @Test 
    public void car_speed_cannot_be_lower_than_0(){
        for (int i = 0; i < 100; i++) {
            myVolvo.brake(1);
        }

        assertFalse(myVolvo.getCurrentSpeed() < 0);
    }

    @Test
    public void moving_and_turning_the_car_to_its_original_position_should_result_in_its_original_position() {
        BigDecimal prevX = myVolvo.getX();
        BigDecimal prevY = myVolvo.getY();

        myVolvo.gas(0.5);

        myVolvo.turnRight();

        myVolvo.move();

        for (int i = 0; i < 4; i ++){
            myVolvo.turnLeft();
        }
        
        myVolvo.move();
        
        assertTrue(BigDecimal.ZERO.equals(prevX) && BigDecimal.ZERO.equals(prevY));
    }
}
