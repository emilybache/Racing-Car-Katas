package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TelemetryDiagnosticControlsTest

{

    private TelemetryDiagnosticControls controls;

    @BeforeEach
    public void setup(){
        controls = new TelemetryDiagnosticControls();
    }


    @Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {

        controls.checkTransmission();
        assertNotNull(controls.getDiagnosticInfo());
    }

}