using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using TDDMicroExercises.TirePressureMonitoringSystem;

namespace TDDMicroExercisesTest
{
    [TestClass]
    public class AlarmTest
    {
        [TestMethod]
        public void Check_UnderPression_Value_True()
        {
            var sensor = new Mock<ISensor>();
            sensor.Setup(i => i.PopNextPressurePsiValue()).Returns(14);

            Threshold threshold = new Threshold(17, 21);

            var alarm = new Alarm(sensor.Object, threshold);
            alarm.Check();

            Assert.AreEqual(true, alarm.AlarmOn);
        }

        [TestMethod]
        public void Check_HighPression_Value_True()
        {
            var sensor = new Mock<ISensor>();
            sensor.Setup(i => i.PopNextPressurePsiValue()).Returns(24);

            Threshold threshold = new Threshold(17, 21);

            var alarm = new Alarm(sensor.Object, threshold);
            alarm.Check();

            Assert.AreEqual(true, alarm.AlarmOn);
        }

        [TestMethod]
        public void Check_BetweenPression_Value_True()
        {
            var sensor = new Mock<ISensor>();
            sensor.Setup(i => i.PopNextPressurePsiValue()).Returns(20);

            Threshold threshold = new Threshold(17, 21);

            var alarm = new Alarm(sensor.Object, threshold);
            alarm.Check();

            Assert.AreEqual(false, alarm.AlarmOn);
        }
    }
}
