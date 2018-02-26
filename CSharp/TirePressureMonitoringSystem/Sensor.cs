using System;

namespace TDDMicroExercises.TirePressureMonitoringSystem
{
    public class Sensor : ISensor
    {
        const double Offset = 16;

        public double PopNextPressurePsiValue()
        {
            double pressureTelemetryValue;
            SamplePressure(out pressureTelemetryValue);

            return Offset + pressureTelemetryValue;
        }

        private static void SamplePressure(out double pressureTelemetryValue)
        {
            // placeholder implementation that simulate a real sensor in a real tire
            Random basicRandomNumbersGenerator = new Random();
            pressureTelemetryValue = 6 * basicRandomNumbersGenerator.NextDouble() * basicRandomNumbersGenerator.NextDouble();
        }
    }
}
