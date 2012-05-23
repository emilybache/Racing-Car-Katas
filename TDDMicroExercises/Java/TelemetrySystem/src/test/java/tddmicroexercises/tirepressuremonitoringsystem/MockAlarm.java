package tddmicroexercises.tirepressuremonitoringsystem;

public class MockAlarm implements IAlarm
{
    private boolean alarmOn;

    private int expectedCheckCallsCount = 0;
    private int actualCheckCallsCount = 0;

    private int expectedAlarmOnCallsCount = 0;
    private int actualAlarmOnCallsCount = 0;

    public void resetExpectedCallsCount()
    {
        expectedCheckCallsCount = 1;
    }

    public void resetAlarmToOn()
    {
        expectedAlarmOnCallsCount = 1;
        alarmOn = true;    
    }

    public void verify()
    {
        if (expectedAlarmOnCallsCount != actualAlarmOnCallsCount)
        {
        	//TODO - find a more appropriate exception
            throw new IllegalArgumentException("AlarmOn calls count" + actualAlarmOnCallsCount + 
            		" expected: " + expectedAlarmOnCallsCount);
        }

        if (expectedCheckCallsCount != actualCheckCallsCount)
        {
            throw new IllegalArgumentException("Check calls count" +  actualCheckCallsCount +
                                                  "expected: " + expectedCheckCallsCount);
        }
    }

    public void check()
    {
        actualCheckCallsCount += 1;
    }

    public boolean isAlarmOn()
    {
            actualAlarmOnCallsCount += 1;
            return alarmOn;
    }
}

