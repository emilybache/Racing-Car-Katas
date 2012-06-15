package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    public static final double LOW_PRESSURE_THRESHOLD = 17;
    public static final double HIGH_PRESSURE_THRESHOLD = 21;

    ISensor sensor;

    boolean alarmOn = false;
    
    public Alarm(){
    	this(new Sensor());
    }
    
    public Alarm(ISensor sensor) {
		this.sensor = sensor;
	}

	public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
