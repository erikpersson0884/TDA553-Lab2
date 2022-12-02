package Trucks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Vehicles.Trucks.Scania;

public class ScaniaTest {
    private Scania myScania;

    @Before
    public void createTestScania() {
        myScania = new Scania(500, Color.BLACK, 0, 0);
    }

    @After
    public void removeTestScania() {
        // Garbage collector deletes
        myScania = null;
    }

    // Tests to do, gas, brake, currentSpeed, move, direction, turn left, turn right
    @Test
    public void gas_cannot_result_in_the_speed_decreasing() {
        double previousSpeed = myScania.getCurrentSpeed();
        myScania.gas(1);
        assertFalse(previousSpeed > myScania.getCurrentSpeed());
    }

    @Test
    public void gas_cannot_take_in_value_below_zero() {
        assertThrows(IllegalArgumentException.class, () -> {
            myScania.gas(-1);
        });
    }

    @Test
    public void brake_cannot_result_in_the_speed_increasing() {
        myScania.gas(0.5);
        double previousSpeed = myScania.getCurrentSpeed();
        myScania.brake(0.1);

        assertFalse(previousSpeed < myScania.getCurrentSpeed());
    }

    @Test
    public void brake_cannot_take_in_value_above_one() {
        assertThrows(IllegalArgumentException.class, () -> {
            myScania.brake(2);
        });
    }

    @Test
    public void car_speed_cannot_be_higher_than_enginePower() {
        for (int i = 0; i < 100; i++) {
            myScania.gas(1);
        }

        assertFalse(myScania.getEnginePower() < myScania.getCurrentSpeed());
    }

    @Test
    public void car_speed_cannot_be_lower_than_0() {
        for (int i = 0; i < 100; i++) {
            myScania.brake(1);
        }

        assertFalse(myScania.getCurrentSpeed() < 0);
    }

    @Test
    public void moving_and_turning_the_car_to_its_original_position_should_result_in_its_original_position() {
        BigDecimal prevX = myScania.getX();
        BigDecimal prevY = myScania.getY();

        myScania.gas(0.5);

        myScania.turnRight();

        myScania.move();

        for (int i = 0; i < 4; i++) {
            myScania.turnLeft();
        }

        myScania.move();

        assertTrue(BigDecimal.ZERO.equals(prevX) && BigDecimal.ZERO.equals(prevY));
    }

    @Test
    public void ramp_cannot_higher_than_70_degrees() {
        myScania.raiseRampToMax();
        myScania.raiseRamp(20);
        assertTrue(myScania.getRampAngle() <= 70);
    }

    @Test
    public void ramp_cannot_be_lower_than_0_degrees() {
        myScania.lowerRampToMin();
        myScania.lowerRamp(20);
        assertTrue(myScania.getRampAngle() >= 0);
    }

    @Test
    public void raising_ramp_cannot_result_in_lowering_ramp() {
        assertThrows(IllegalArgumentException.class, () -> {
            myScania.raiseRamp(-5);
        });
    }

    @Test
    public void lowering_ramp_cannot_result_in_raising_ramp() {
        assertThrows(IllegalArgumentException.class, () -> {
            myScania.lowerRamp(-5);
        });
    }
}
