using System;

namespace TDDMicroExercises.TirePressureMonitoringSystem.Tests
{
    public class MockAlarm : IAlarm
    {
        private bool _alarmOnReturnValue;

        private int _expectedCheckCallsCount = 0;
        private int _actualCheckCallsCount = 0;

        private int _expectedAlarmOnCallsCount = 0;
        private int _actualAlarmOnCallsCount = 0;

        public void SetExpectedCallToCheck()
        {
            _expectedCheckCallsCount = 1;
        }

        public void SetExpectedGetAlarmOn(bool returnValue)
        {
            _expectedAlarmOnCallsCount = 1;
            _alarmOnReturnValue = true;    
        }

        public void Verify()
        {
            if (_expectedAlarmOnCallsCount != _actualAlarmOnCallsCount)
            {
                throw new ArgumentOutOfRangeException("AlarmOn calls count", _actualAlarmOnCallsCount,
                                                      " expected: " + _expectedAlarmOnCallsCount);
            }

            if (_expectedCheckCallsCount != _actualCheckCallsCount)
            {
                throw new ArgumentOutOfRangeException("Check calls count", _actualCheckCallsCount,
                                                      "expected: " + _expectedCheckCallsCount);
            }
        }

        void IAlarm.Check()
        {
            _actualCheckCallsCount += 1;
        }

        bool IAlarm.AlarmOn
        {
            get
            {
                _actualAlarmOnCallsCount += 1;
                return _alarmOnReturnValue;
            }
        }
    }
}
