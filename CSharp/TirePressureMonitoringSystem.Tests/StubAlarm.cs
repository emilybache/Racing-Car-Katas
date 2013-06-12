namespace TDDMicroExercises.TirePressureMonitoringSystem.Tests
{
    public class StubAlarm : IAlarm
    {
        private bool _alarmOnReturnValue;

        public void StubGetAlarmOn(bool returnValue)
        {
            _alarmOnReturnValue = returnValue;
        }

        void IAlarm.Check()
        {
            return;
        }

        bool IAlarm.AlarmOn
        {
            get { return _alarmOnReturnValue; }
        }
    }
}
