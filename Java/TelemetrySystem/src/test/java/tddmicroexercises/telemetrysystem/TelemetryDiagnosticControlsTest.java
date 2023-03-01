package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TelemetryDiagnosticControlsTest
{
    private TelemetryDiagnosticControlsImpl telemetryDiagnosticControls;

    @BeforeEach
    public void init () {
        telemetryDiagnosticControls = new TelemetryDiagnosticControlsImpl();
    }

	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {

        telemetryDiagnosticControls.checkTransmission(3);


        final String diagnosticMessageResult =
                "LAST TX rate................ 100 MBPS\r\n"
                        + "HIGHEST TX rate............. 100 MBPS\r\n"
                        + "LAST RX rate................ 100 MBPS\r\n"
                        + "HIGHEST RX rate............. 100 MBPS\r\n"
                        + "BIT RATE.................... 100000000\r\n"
                        + "WORD LEN.................... 16\r\n"
                        + "WORD/FRAME.................. 511\r\n"
                        + "BITS/FRAME.................. 8192\r\n"
                        + "MODULATION TYPE............. PCM/FM\r\n"
                        + "TX Digital Los.............. 0.75\r\n"
                        + "RX Digital Los.............. 0.10\r\n"
                        + "BEP Test.................... -5\r\n"
                        + "Local Rtrn Count............ 00\r\n"
                        + "Remote Rtrn Count........... 00";

        assertNotNull(telemetryDiagnosticControls.telementryDiagnosticInfo.getDiagnosticInfo());
        assertEquals(diagnosticMessageResult, telemetryDiagnosticControls.telementryDiagnosticInfo.getDiagnosticInfo());
    }

    @Test
    public void check_set_diagnostic_info() throws Exception {

        telemetryDiagnosticControls.telementryDiagnosticInfo.setDiagnosticInfo("test info");

        assertNotNull(telemetryDiagnosticControls.telementryDiagnosticInfo.getDiagnosticInfo());
        assertEquals("test info", telemetryDiagnosticControls.telementryDiagnosticInfo.getDiagnosticInfo());
    }
}
