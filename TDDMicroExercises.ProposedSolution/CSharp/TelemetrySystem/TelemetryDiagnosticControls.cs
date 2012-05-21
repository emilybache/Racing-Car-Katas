using System;

namespace TDDMicroExercises.OneSolution.TelemetrySystem
{
    public class TelemetryDiagnosticControls
    {
        private const string DiagnosticChannelConnectionString = "*111#";
        
        private readonly IConnection _connection;
        private readonly IDataChannel _dataChannel;

        private string _diagnosticInfo = string.Empty;


        public TelemetryDiagnosticControls(IConnection connection, IDataChannel dataChannel)
        {
            _connection = connection;
            _dataChannel = dataChannel;
        }


        public TelemetryDiagnosticControls()
            : this(new TelemetryClientConnection(), new TelemetryDataChannel())
        {
        }


        public string DiagnosticInfo
        {
            get { return _diagnosticInfo; }
            set { _diagnosticInfo = value; }
        }

        public void CheckTransmission()
        {
            _diagnosticInfo = string.Empty;

            _connection.Disconnect();

            int retryLeft = 3;
            while (_connection.OnlineStatus == false && retryLeft > 0)
            {
                _connection.Connect(DiagnosticChannelConnectionString);
                retryLeft -= 1;
            }

            if (_connection.OnlineStatus == false)
            {
                throw new Exception("Unable to connect.");
            }

            _dataChannel.Send(TelemetryDataChannel.DiagnosticMessage);
            _diagnosticInfo = _dataChannel.Receive();
            _connection.Disconnect();
        }
    }
}
