package tddmicroexercises.telemetrysystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TelemetryDiagnosticControlsRegressionTest{
	@Test
	// Regression test to ensure existing API is not broken
	public void regressionTest() throws Exception{
		TelemetryDiagnosticControls controls = new TelemetryDiagnosticControls();
		
		controls.checkTransmission();
		
		assertNotNull(controls.getDiagnosticInfo());
	}
}
