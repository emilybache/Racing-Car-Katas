package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tddmicroexercises.telemetrysystem.services.impl.ClientImpl;
import tddmicroexercises.telemetrysystem.services.impl.ConnectionImpl;
import tddmicroexercises.telemetrysystem.services.impl.TelemetryDiagnosticControls;


public class TelemetryDiagnosticControlsTest {
    public TelemetryDiagnosticControlsTest() {
    }

    @Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        String diagnosticInfo = "test";
        TelemetryClient telemetryClient = (TelemetryClient)Mockito.mock(TelemetryClient.class);
        ConnectionImpl connection = (ConnectionImpl)Mockito.mock(ConnectionImpl.class);
        ClientImpl client = (ClientImpl)Mockito.mock(ClientImpl.class);
        ((ConnectionImpl)Mockito.doNothing().when(connection)).disconnect();
        Mockito.when(client.getOnlineStatus()).thenReturn(true);
        Mockito.when(client.receive()).thenReturn(diagnosticInfo);
        ((ClientImpl)Mockito.doNothing().when(client)).send("AT#UD");
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(client, connection);
        telemetryDiagnosticControls.setDiagnosticInfo(diagnosticInfo);
        telemetryDiagnosticControls.checkTransmission();
        Assertions.assertEquals(diagnosticInfo, telemetryDiagnosticControls.getDiagnosticInfo());
    }

}
