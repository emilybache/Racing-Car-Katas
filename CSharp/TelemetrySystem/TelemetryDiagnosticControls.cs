
using System;

namespace TDDMicroExercises.TelemetrySystem
{
    public class TelemetryDiagnosticControls
    {
        private const string DiagnosticChannelConnectionString = "*111#";

        public ITelemetryClient TelemetryClient { get; }
        private string _diagnosticInfo = string.Empty;

        public TelemetryDiagnosticControls(ITelemetryClient telemetryClient)
        {
            this.TelemetryClient = telemetryClient;
        }

        public string DiagnosticInfo
        {
            get { return _diagnosticInfo; }
            set { _diagnosticInfo = value; }
        }

        public void CheckTransmission()
        {
            _diagnosticInfo = string.Empty;

            TelemetryClient.Disconnect();

            int retryLeft = 3;
            while (TelemetryClient.IsConnected() == false && retryLeft > 0)
            {
                TelemetryClient.Connect(DiagnosticChannelConnectionString);
                retryLeft -= 1;
            }
             
            if(TelemetryClient.IsConnected() == false)
            {
                throw new Exception("Unable to connect.");
            }

            TelemetryClient.Send(TelemetrySystem.TelemetryClient.DiagnosticMessage);
            _diagnosticInfo = TelemetryClient.Receive();
        }
    }
}
