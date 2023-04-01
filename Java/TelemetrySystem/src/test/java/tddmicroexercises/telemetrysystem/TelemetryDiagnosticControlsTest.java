package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class TelemetryDiagnosticControlsTest
{
    
	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        String diagnosticInfo="test";
        TelemetryClient telemetryClient = mock(TelemetryClient.class);
        Connection connectionService = mock(TelemetryConnectionService.class);
        Mockito.when(connectionService.getOnlineStatus()).thenReturn(true);
        TransmissionService transmissionService = mock(TelemetryTransmissionService.class);
        Mockito.when(transmissionService.receive()).thenReturn(diagnosticInfo);
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(transmissionService, connectionService);
        telemetryDiagnosticControls.setDiagnosticInfo(diagnosticInfo);
        telemetryDiagnosticControls.checkTransmission();
        Assertions.assertEquals(diagnosticInfo, telemetryDiagnosticControls.getDiagnosticInfo());
        Assertions.assertEquals(diagnosticInfo, telemetryDiagnosticControls.getDiagnosticInfo());
    }

    @Test()
    void giving_unable_to_connect_exception() throws Exception {
        String diagnosticInfo="test";
        TelemetryClient telemetryClient = mock(TelemetryClient.class);
        Connection connectionService = mock(TelemetryConnectionService.class);
        TransmissionService transmissionService = mock(TelemetryTransmissionService.class);
        Mockito.when(transmissionService.receive()).thenReturn(diagnosticInfo);
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(transmissionService, connectionService);
        Exception exception = Assertions.assertThrows(Exception.class, telemetryDiagnosticControls::checkTransmission);
        String expectedMessage = "Unable to connect.";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

}
