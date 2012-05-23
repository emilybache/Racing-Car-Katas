package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm implements IAlarm
{
    private final double LowPressureTreshold = 17;
    private final double HighPressureTreshold = 21;

    Sensor sensor = new Sensor();

    boolean alarmOn = false;
    private long alarmCount = 0;

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureTreshold || HighPressureTreshold < psiPressureValue)
        {
            alarmOn = true;
            alarmCount += 1;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
