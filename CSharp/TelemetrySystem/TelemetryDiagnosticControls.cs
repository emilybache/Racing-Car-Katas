using System;

namespace TDDMicroExercises.TelemetrySystem;

public class TelemetryDiagnosticControls
{
    private const string DiagnosticChannelConnectionString = "*111#";

    public string DiagnosticInfo { get; set; } = string.Empty;

    public ITelemetryClient TelemetryClient { get; }

    public TelemetryDiagnosticControls(ITelemetryClient telemetryClient)
    {
        this.TelemetryClient = telemetryClient;
    }

    public void CheckTransmission()
    {
        this.DiagnosticInfo = string.Empty;

        this.TelemetryClient.Disconnect();

        var retryLeft = 3;
        while (this.TelemetryClient.IsConnected() == false && retryLeft > 0)
        {
            this.TelemetryClient.Connect(TelemetryDiagnosticControls.DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if (this.TelemetryClient.IsConnected() == false) throw new Exception("Unable to connect.");

        this.TelemetryClient.Send(TelemetrySystem.TelemetryClient.DiagnosticMessage);
        this.DiagnosticInfo = this.TelemetryClient.Receive();
    }
}