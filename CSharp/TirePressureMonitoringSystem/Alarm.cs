namespace TDDMicroExercises.TirePressureMonitoringSystem
{
    public class Alarm
    {
        readonly ISensor _sensor;
        private Threshold threshold;

        public Alarm(ISensor sensor, Threshold threshold)
        {
            this._sensor = sensor;
            this.threshold = threshold;
        }

        public void Check()
        {
            double psiPressureValue = _sensor.PopNextPressurePsiValue();

            if (psiPressureValue < threshold.Min || threshold.Max < psiPressureValue)
            {
                this.AlarmOn = true;
            }
        }

        public bool AlarmOn
        {
            get; private set;
        }

    }

    public class Threshold
    {

        public double Min
        {
            get;
            private set;
        }

        public double Max
        {
            get;
            private set;
        }

        public Threshold(double minThreshold, double maxThreshold)
        {
            this.Min = minThreshold;
            this.Max = maxThreshold;
        }
    }
}
