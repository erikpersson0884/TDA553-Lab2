package Cars;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TransporterTest {
    private Transporter Transporter;
    
    @Before
    public void createTestTransporter() {
        Transporter = new Transporter(500, Color.BLACK, 0, 0);
    }

    @After
    public void removeTestScania(){
        // Garbage collector deletes
        Transporter = null;
    }

    // Tests to do, gas, brake, currentSpeed, move, direction, turn left, turn right
    @Test
    public void gas_cannot_result_in_the_speed_decreasing(){
        double previousSpeed =  Transporter.getCurrentSpeed();
        Transporter.gas(1);
        assertFalse(previousSpeed > Transporter.getCurrentSpeed());
    }

    @Test
    public void gas_cannot_take_in_value_below_zero(){
        assertThrows(IllegalArgumentException.class, () -> {          
            Transporter.gas(-1);  
        });
    }
    @Test
    public void brake_cannot_result_in_the_speed_increasing(){   
        Transporter.gas(0.5);
        double previousSpeed =  Transporter.getCurrentSpeed();
        Transporter.brake(0.1);

        assertFalse(previousSpeed < Transporter.getCurrentSpeed());
    }

    @Test
    public void brake_cannot_take_in_value_above_one(){
        assertThrows(IllegalArgumentException.class, () -> {          
            Transporter.brake(2);
        });
    }

    @Test 
    public void car_speed_cannot_be_higher_than_enginePower(){
        for (int i = 0; i < 100; i++){
            Transporter.gas(1);
        }
       
        assertFalse(Transporter.getEnginePower() <  Transporter.getCurrentSpeed());
    }

    @Test 
    public void car_speed_cannot_be_lower_than_0(){
        for (int i = 0; i < 100; i++) {
            Transporter.brake(1);
        }

        assertFalse(Transporter.getCurrentSpeed() < 0);
    }

    @Test
    public void moving_and_turning_the_car_to_its_original_position_should_result_in_its_original_position() {
        BigDecimal prevX = Transporter.getX();
        BigDecimal prevY = Transporter.getY();

        Transporter.gas(0.5);

        Transporter.turnRight();

        Transporter.move();

        for (int i = 0; i < 4; i ++){
            Transporter.turnLeft();
        }
        
        Transporter.move();
        
        assertTrue(BigDecimal.ZERO.equals(prevX) && BigDecimal.ZERO.equals(prevY));
    }

    @Test
    public void ramp_raises_when_raised(){
        Transporter.raiseRamp();
        assertFalse(Transporter.getRampIsDown());
    }

    @Test
    public void ramp_lowers_when_lowered() {
        Transporter.lowerRamp();
        assertTrue(Transporter.getRampIsDown());
    }
}
