import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TelemetryDiagnosticControlsTest {
    private TelemetryDiagnosticControls telemetryDiagnosticControls;
    private TelemetryClient telemetryClient;

    @BeforeEach
    public void prerequisiteForTestDiagnosticControls() {
        telemetryClient = mock(TelemetryClient.class);
        telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient);
    }

    @Test
    public void testGetDiagnosticInfo() {
        String expectedDiagnosticInfo = "Diagnostic Information";
        when(telemetryClient.getDiagnosticInfo()).thenReturn(expectedDiagnosticInfo);
        String diagnosticInfo = diagnosticControls.getDiagnosticInfo();
        assertEquals(expectedDiagnosticInfo, diagnosticInfo);
    }

    @Test
    public void testCheckTransmissionSuccess() throws ConnectionException, NoMessageReceivedException {
        when(telemetryClient.getOnlineStatus()).thenReturn(true);
        when(telemetryClient.receive()).thenReturn("Diagnostic Message");
        assertDoesNotThrow(() -> diagnosticControls.checkTransmission());
    }

    @Test
    public void testCheckTransmissionFailureNoMessageReceivedException()  {
        when(telemetryClient.getOnlineStatus()).thenReturn(true);
        when(telemetryClient.receive()).thenReturn(null);
        assertThrows(NoMessageReceivedException.class, () -> diagnosticControls.checkTransmission());
    }

    @Test
    public void testCheckTransmissionFailureConnectionException() {
        when(telemetryClient.getOnlineStatus()).thenReturn(false);
        assertThrows(ConnectionException.class, () -> diagnosticControls.checkTransmission());
    }



}
