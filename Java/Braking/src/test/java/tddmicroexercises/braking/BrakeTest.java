package tddmicroexercises.braking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BrakeTest {

    @Test
    public void testPowerDissipation() throws Exception {
        Brake brake = new Brake();
        assertEquals(330000.0, brake.powerDissipation(110), 0.1);
    }
}
