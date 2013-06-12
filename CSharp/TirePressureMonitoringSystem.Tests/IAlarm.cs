namespace TDDMicroExercises.TirePressureMonitoringSystem
{
    public interface IAlarm
    {
        void Check();

        bool AlarmOn { get; }
    }
}