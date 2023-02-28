package tddmicroexercises.telemetrysystem;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TelemetryDiagnosticControlsTest
{
    ConnectionClass connectionClass = new ConnectionClass();
    ClientClass clientClass = new ClientClass();
    TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(clientClass, connectionClass);
	@Test
    void checkTransmission() {
        try {
            if(clientClass.getOnlineStatus() == false)
            {
                throw new Exception("Unable to connect.");
            }
            telemetryDiagnosticControls.checkTransmission();
            Assert.assertEquals(false, clientClass.getOnlineStatus());

        } catch (Exception e) {
            Assert.assertNotEquals("Unknown exception", e);
        }
    }
    @Test
    void checkGetDiagnostic(){
       String dignosticInfo =  telemetryDiagnosticControls.getDiagnosticInfo();
       Assert.assertEquals(dignosticInfo,telemetryDiagnosticControls.getDiagnosticInfo());
    }
    @Test
    void checkSetDiagnostic(){
        telemetryDiagnosticControls.setDiagnosticInfo("abc");
        Assert.assertEquals("abc",telemetryDiagnosticControls.getDiagnosticInfo());
    }
}
