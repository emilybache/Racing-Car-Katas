package tddmicroexercises.telemetrysystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TelemetryDiagnosticControlsCoveringsTests{
	@Test
	// Regression test to ensure existing API is not broken
	public void checkTransmissionShouldSetDiagnosticInfo() throws Exception{
		TelemetryDiagnosticControls controls = new TelemetryDiagnosticControls();
		
		controls.checkTransmission();
		
		assertNotNull(controls.getDiagnosticInfo());
	}
	
}
