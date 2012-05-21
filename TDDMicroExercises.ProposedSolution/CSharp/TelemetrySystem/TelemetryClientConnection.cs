using System;

namespace TDDMicroExercises.OneSolution.TelemetrySystem
{
    public class TelemetryClientConnection : IConnection
    {
        private bool _onlineStatus;
        private readonly Random _connectionEventsSimulator = new Random(42);

        public bool OnlineStatus
        {
            get { return _onlineStatus; }
        }

        public void Connect(string telemetryServerConnectionString)
        {
            if (string.IsNullOrEmpty(telemetryServerConnectionString))
            {
                throw new ArgumentNullException();
            }

            // simulate the operation on a real modem
            bool success = _connectionEventsSimulator.Next(1, 10) <= 8;

            _onlineStatus = success;
        }

        public void Disconnect()
        {
            _onlineStatus = false;
        }
    }
}
