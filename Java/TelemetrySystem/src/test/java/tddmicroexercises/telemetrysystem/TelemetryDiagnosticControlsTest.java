package tddmicroexercises.telemetrysystem;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class TelemetryDiagnosticControlsTest
{
	@InjectMocks
	private TelemetryDiagnosticControls diagnosticControl;
    
    @Mock
    private TelemetryClient telemetryClient;
    
    @Test
    public void testCheckTransmissionWhenOnline() throws Exception {
        when(telemetryClient.getOnlineStatus()).thenReturn(true);
        diagnosticControl.checkTransmission();
        verify(telemetryClient).send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        verify(telemetryClient).receive();
        assertEquals("", diagnosticControl.getDiagnosticInfo());
    }
    
    @Test(expected=Exception.class)
    public void testCheckTransmissionWhenOffline() throws Exception {
        when(telemetryClient.getOnlineStatus()).thenReturn(false);
        diagnosticControl.checkTransmission();
    }
}
