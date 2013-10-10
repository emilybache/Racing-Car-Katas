from client import TelemetryClient

class TelemetryDiagnostics:
    DiagnosticChannelConnectionString = "*111#"

    def __init__(self):
        self._telemetry_client = TelemetryClient()
        self.diagnostic_info = ""

    def check_transmission(self):
        self.diagnostic_info = ""
        self._telemetry_client.disconnect()

        retryLeft = 3
        while ((not self._telemetry_client.online_status) and retryLeft > 0):
            self._telemetry_client.connect(TelemetryDiagnostics.DiagnosticChannelConnectionString)
            retryLeft -= 1

        if not self._telemetry_client.online_status:
            raise Exception("Unable to connect.")

        self._telemetry_client.send(TelemetryClient.DIAGNOSTIC_MESSAGE)
        self.diagnostic_info = self._telemetry_client.receive()


