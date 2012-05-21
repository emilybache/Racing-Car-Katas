using NUnit.Framework;

namespace TDDMicroExercises.OneSolution.TirePressureMonitoringSystem.Tests
{
    [TestFixture]
    public class AlarmTest
    {
        [Test]
        public void a_normal_pressure_value_should_not_raise_the_alarm()
        {
            StubSensor stubSensor = new StubSensor();
            stubSensor.StubCallToPopNextPressurePsiValue(Alarm.LowPressureTreshold);
            Alarm target = new Alarm(stubSensor);

            target.Check();

            Assert.AreEqual(false, target.AlarmOn, "alarm on");
        }

        [Test]
        public void a_pressure_value_out_of_range_should_raise_the_alarm()
        {
            StubSensor stubSensor = new StubSensor();
            stubSensor.StubCallToPopNextPressurePsiValue(Alarm.LowPressureTreshold -1);
            Alarm target = new Alarm(stubSensor);

            target.Check();

            Assert.AreEqual(true, target.AlarmOn, "alarm on");
        }

        [Test]
        public void a_normal_pressure_value_after_an_out_of_range_pressure_value_should_keep_the_alarm_on()
        {
            StubSensor stubSensor = new StubSensor();
            stubSensor.StubCallToPopNextPressurePsiValues(new double[] { Alarm.LowPressureTreshold, Alarm.LowPressureTreshold - 1, Alarm.LowPressureTreshold });
            Alarm target = new Alarm(stubSensor);

            target.Check();
            target.Check();
            target.Check();

            Assert.AreEqual(true, target.AlarmOn, "alarm on");
        }
    }
}
