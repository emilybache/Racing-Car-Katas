
using System.Collections.Generic;

namespace TDDMicroExercises.OneSolution.TirePressureMonitoringSystem.Tests
{
    public class StubSensor : ISensor
    {
        private readonly Stack<double> _returnedValues = new Stack<double>();

        public void StubCallToPopNextPressurePsiValue(double returnedValue) 
        {
            StubCallToPopNextPressurePsiValues(new double[] { returnedValue });
        }

        public void StubCallToPopNextPressurePsiValues(double[] returnedValues)
        {
            foreach (double expectedValue in returnedValues)
            {
                _returnedValues.Push(expectedValue);                 
            }
        }

        double ISensor.PopNextPressurePsiValue()
        {
            return _returnedValues.Pop();
        }
    }
}
