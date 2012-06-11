package tddmicroexercises.telemetrysystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.net.ConnectException;

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
	public void regressionTest() throws Exception{
		TelemetryDiagnosticControls controls = new TelemetryDiagnosticControls();
		
		controls.checkTransmission();
		
		assertNotNull(controls.getDiagnosticInfo());
	}
	
	@Test
    public void shouldSendADiagnosticMessageAndReceiveAStatusMessageResponse() throws Exception{
		telemetryConnectionMock.setOnlineStatus(true);
		String diagnosticMessage = "Diagnostic Message";
		telemetryDataChannelMock.setDiagnosticMessage(diagnosticMessage);
		
		controls.checkTransmission();
		
		assertTrue(telemetryDataChannelMock.hasSentMessage(IDataChannel.DIAGNOSTIC_MESSAGE));
		assertEquals(diagnosticMessage,controls.getDiagnosticInfo());
    }
	
	@Test
	public void shouldRetryConnectionIfConnectionFailsOnFirstAttemptAndIsSuccessfulOnSecondAttempt() throws Exception{
		telemetryConnectionMock.setOnlineStatus(true, false, false);
		
		controls.checkTransmission();
		
		assertEquals(2, telemetryConnectionMock.getConnectCallCount());
		assertTrue(telemetryDataChannelMock.hasSentMessage(IDataChannel.DIAGNOSTIC_MESSAGE));
	}
	
	@Test(expected=ConnectException.class)
	public void shouldThrowExceptionIfConnectionFailureIsRepeated() throws Exception{
		telemetryConnectionMock.setOnlineStatus(false, false, false, false);
		
		controls.checkTransmission();
	}
	
	@Test
	public void shouldDisconnectClientOnEveryCheck() throws Exception{
		telemetryConnectionMock.setOnlineStatus(true);

		controls.checkTransmission();
		controls.checkTransmission();
		
		assertEquals(2, telemetryConnectionMock.getDisconnectCallCount());
	}

	@Test
	public void shouldConnectUsingConnectionString() throws Exception{
		telemetryConnectionMock.setOnlineStatus(true, false);

		controls.checkTransmission();
		
		assertEquals(TelemetryDiagnosticControls.CONNECTION_STRING, telemetryConnectionMock.getConnectString());
	}
}
