package tddmicroexercises.telemetrysystem;

            import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TelemetryDiagnosticControlsTest
{
    static TelemetryDiagnosticControls telemetryDiagnosticControls;
    static TelemetryClientConnectionManager telemetryClientConnectionManager;

    static TelemetryClient telemetryClient;
    @BeforeAll
    static void beforeAll(){
        telemetryDiagnosticControls = new TelemetryDiagnosticControls();
        telemetryClient = new TelemetryClient();
        telemetryClientConnectionManager = new TelemetryClientConnectionManager();
    }
	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response()
    {
        telemetryDiagnosticControls.setDiagnosticInfo("Test");
        try{
            telemetryDiagnosticControls.checkTransmission();
        }catch(Exception e){

        }
        telemetryClient.send("Hello World!!");
        String receivedMessage = telemetryClient.receive();
    }

}
