namespace TDDMicroExercises.OneSolution.TelemetrySystem
{
    public interface IConnection
    {
        bool OnlineStatus { get; }

        void Connect(string telemetryServerConnectionString);
        void Disconnect();
    }
}