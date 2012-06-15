package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AlarmTests {
	
	private static final double HIGH_PRESSURE = Alarm.HIGH_PRESSURE_THRESHOLD + 1;
	private static final double LOW_PRESSURE = Alarm.LOW_PRESSURE_THRESHOLD - 1;
	private static final double NORMAL_PRESSURE = Alarm.LOW_PRESSURE_THRESHOLD + ((Alarm.HIGH_PRESSURE_THRESHOLD - Alarm.LOW_PRESSURE_THRESHOLD)/2);
	private StubSensor stubSensor;
	private Alarm alarm;

	@Before
	public void setUp(){
		stubSensor = new StubSensor();
		alarm  = new Alarm(stubSensor);
	}
	
	@Test
	public void alarmIsTriggeredBySensorReadingBelowLowPressureValue() {
		stubSensor.pushPsiValue(LOW_PRESSURE);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void alarmIsTriggeredBySensorReadingAboveHighPressureValue() {
		stubSensor.pushPsiValue(HIGH_PRESSURE);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void alarmIsNotTriggeredBySensorReadingANormalPresureValue(){
		double pressureValue = NORMAL_PRESSURE;
		stubSensor.pushPsiValue(pressureValue);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}
	
	@Test
	public void alarmRemainsOnAfterTriggering(){
		stubSensor.pushPsiValue(HIGH_PRESSURE);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
		stubSensor.pushPsiValue(NORMAL_PRESSURE);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
}
