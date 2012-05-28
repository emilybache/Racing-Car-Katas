package tddmicroexercises.tirepressuremonitoringsystem;


public class StubAlarm implements IAlarm
{
    private boolean alarmOnReturnValue;

    public void setAlarmOn(boolean returnValue)
    {
        alarmOnReturnValue = returnValue;
    }

    public void check()
    {
        return;
    }

    public boolean isAlarmOn()
    {
        return alarmOnReturnValue;
    }
}

