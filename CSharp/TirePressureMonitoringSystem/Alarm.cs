namespace TDDMicroExercises.TirePressureMonitoringSystem
{
    public class Alarm
    {
        private const double LowPressureTreshold = 17;
        private const double HighPressureTreshold = 21;

        Sensor _sensor = new Sensor();

        bool _alarmOn = false;
        private long _alarmCount = 0;


        public void Check()
        {
            double psiPressureValue = _sensor.PopNextPressurePsiValue();

            if (psiPressureValue < LowPressureTreshold || HighPressureTreshold < psiPressureValue)
            {
                _alarmOn = true;
                _alarmCount += 1;
            }
        }

        public bool AlarmOn
        {
            get { return _alarmOn; }
        }

    }
}
