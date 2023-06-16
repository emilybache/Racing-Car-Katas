package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TelemetryDiagnosticControlsTest {

    private TelemetryClient telemetryClient;
    private TelemetryDiagnosticControls diagnosticControls;

    @BeforeEach
    public void prerequisitesForTest() {
        telemetryClient = mock(TelemetryClient.class);
        diagnosticControls = new TelemetryDiagnosticControls(telemetryClient);
    }

    @Test
    void checkTransmission_SendsDiagnosticRequestAndReceivesResponse() throws Exception {
        when(telemetryClient.getOnlineStatus()).thenReturn(true);
        when(telemetryClient.receive()).thenReturn("Diagnostic Information");
        diagnosticControls.checkTransmission();
        verify(telemetryClient).connect("*111#");
        verify(telemetryClient).send(TelemetryDiagnosticControls.DIAGNOSTIC_MESSAGE);
        verify(telemetryClient).disconnect();
        assertEquals("Diagnostic Information", diagnosticControls.getDiagnosticInfo());
    }

    @Test
    void checkTransmission_ThrowsExceptionIfUnableToConnect() {
        when(telemetryClient.getOnlineStatus()).thenReturn(false);
        assertThrows(Exception.class, () -> diagnosticControls.checkTransmission());
        verify(telemetryClient).connect("*111#");
        verifyNoMoreInteractions(telemetryClient);
        assertTrue(diagnosticControls.getDiagnosticInfo().isEmpty());
    }
}
