package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TelemetryDiagnosticControlsTest
{


    TelemetryDiagnosticControls objectUnderTest;

    @BeforeAll
    public void setUp(){

        objectUnderTest = new TelemetryDiagnosticControls();
    }

	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        objectUnderTest.checkTransmission();
        Assertions.assertNotNull(objectUnderTest.getDiagnosticInfo());
    }


}
