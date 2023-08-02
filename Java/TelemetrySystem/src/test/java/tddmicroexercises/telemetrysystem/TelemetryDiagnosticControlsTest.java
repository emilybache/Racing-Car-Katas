package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class TelemetryDiagnosticControlsTest
{


    @Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        String result="test";
        TelemetryClient telemetryClient = mock(TelemetryClient.class);
        Connection con = mock(ConnectionImpl.class);
        Mockito.when(con.getOnlineStatus()).thenReturn(true);
        Transmission trans = mock(TransmissionImpl.class);
        Mockito.when(trans.receive()).thenReturn(result);
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(trans, con);
        telemetryDiagnosticControls.setDiagnosticInfo(result);
        telemetryDiagnosticControls.checkTransmission();
        Assertions.assertEquals(result, telemetryDiagnosticControls.getDiagnosticInfo());
    }

    @Test()
    void checkInitialStatus()  {
        Connection con = mock(Connection.class);
        Assertions.assertEquals(con.getOnlineStatus(),false);
    }

//    @Test()
//    void checkInitialStatusafter_connect()  {
//        Connection con = mock(Connection.class);
//        con.connect("connect");
//        Assertions.assertEquals(con.getOnlineStatus(),true);
//    }


    @Test()
    void checkTransmission_connection_fail() {
        String diagnosticInfo="test";
        TelemetryClient telemetryClient = mock(TelemetryClient.class);
        Connection con = mock(Connection.class);
        Transmission trans = mock(TransmissionImpl.class);
        Mockito.when(trans.receive()).thenReturn(diagnosticInfo);
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(trans, con);
        Exception exception = Assertions.assertThrows(Exception.class, telemetryDiagnosticControls::checkTransmission);
        String expectedMessage = "Unable to connect.";
        Assertions.assertEquals(expectedMessage,exception.getMessage());
    }

}
