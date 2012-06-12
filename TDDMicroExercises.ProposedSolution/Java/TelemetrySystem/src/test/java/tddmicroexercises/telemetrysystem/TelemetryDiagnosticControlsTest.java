package tddmicroexercises.telemetrysystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TelemetryDiagnosticControlsTest{
	
	private TelemetryConnectionMock telemetryConnectionMock;
	private TelemetryDataChannelMock telemetryDataChannelMock;
	private TelemetryDiagnosticControls controls;

	@Before
	public void setUp(){
		telemetryConnectionMock = new TelemetryConnectionMock();
		telemetryDataChannelMock = new TelemetryDataChannelMock();
	    controls = new TelemetryDiagnosticControls(telemetryConnectionMock, telemetryDataChannelMock);
	}
    
	@Test
    public void shouldSendADiagnosticMessageAndReceiveAStatusMessageResponse() throws Exception{
		telemetryConnectionMock.setOnlineStatus(true);
		String diagnosticInfo = "Diagnostic Message";
		telemetryDataChannelMock.setDiagnosticMessage(diagnosticInfo);
		
		controls.checkTransmission();
		
		assertTrue(telemetryDataChannelMock.hasSentMessage(IDataChannel.DIAGNOSTIC_MESSAGE));
		assertEquals(diagnosticInfo,controls.getDiagnosticInfo());
    }
}
