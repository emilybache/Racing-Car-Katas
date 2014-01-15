package tddmicroexercises.braking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BrakingCalculationTest {

    @Test
    public void kineticEnergy() {
        assertEquals(4235000, BrakingCalculation.calculateKineticEnergy(110.0, 700.0), 0.1);
    }

    @Test
    public void speed() {
        assertEquals(110.0, BrakingCalculation.calculateVelocity(4235000.0, 700.0), 0.1);
    }

    @Test
    public void stoping_distance_with_zero_speed() {
        assertEquals(0.0, BrakingCalculation.calculateStoppingDistance(0.0, 700.0, new Brake()), 0.1);
    }

    @Test
    public void update_velocity() {
        assertEquals(105.6, BrakingCalculation.updatedVelocity(110.0, 700.0, new Brake()), 0.1);
    }

    @Test
    @Ignore("This test makes the others fail")
    public void stoping_distance_with_high_speed_failing_braking_strategy() {
        assertEquals(261.6, BrakingCalculation.calculateStoppingDistance(125.0, 700.0, new Brake(new FailingBrakingStrategy())), 0.1);
    }

    @Test
    public void stoping_distance_with_high_speed_abs() {
        assertEquals(267.3, BrakingCalculation.calculateStoppingDistance(125.0, 700.0, new Brake(new IntervalBrakingStrategy())), 0.1);
    }


    @Test
    public void update_velocity_low_speed() {
        assertEquals(9.81, BrakingCalculation.updatedVelocity(15.0, 700.0, new Brake()), 0.1);
    }

    @Test
    public void update_velocity_from_low_speed() {
        assertEquals(20.2, BrakingCalculation.updatedVelocity(25.0, 700.0, new Brake()), 0.1);
    }


    @Test
    public void stoping_distance_with_high_speed() {
        assertEquals(176.1, BrakingCalculation.calculateStoppingDistance(125.0, 700.0, new Brake()), 0.1);
    }
}
