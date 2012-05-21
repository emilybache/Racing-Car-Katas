namespace TDDMicroExercises.OneSolution.TelemetrySystem.Tests
{
    public class StubTelemetryConnection : IConnection
    {
        private bool _onlineStatus;

        public void StubGetOnlineStatus(bool returnValue)
        {
            _onlineStatus = returnValue;
        }

        bool IConnection.OnlineStatus
        {
            get { return _onlineStatus; }
        }

        void IConnection.Connect(string telemetryServerConnectionString)
        {
            return;
        }

        void IConnection.Disconnect()
        {
            return;
        }

    }
}