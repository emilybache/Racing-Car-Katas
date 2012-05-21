namespace TDDMicroExercises.OneSolution.TelemetrySystem
{
    public interface IDataChannel
    {
        void Send(string message);
        string Receive();
    }
}