package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TransmissionImpl implements  Transmission{
    public static final String DIAGNOSTIC_MESSAGE = "AT#UD";
    private String diagnosticMessageResult = "";
    private final Random connectionEventsSimulator = new Random(42);
    private final String DiagnosticChannelConnectionString = "*111#";
    private String diagnosticInfo = "";
    private Connection connection;

    public TransmissionImpl(Connection connection) {
        this.connection = connection;
    }

    public TransmissionImpl(String diagnosticMessageResult, String diagnosticInfo, Connection connection) {
        this.diagnosticMessageResult = diagnosticMessageResult;
        this.diagnosticInfo = diagnosticInfo;
        this.connection = connection;
    }

    public TransmissionImpl(String diagnosticMessageResult, String diagnosticInfo) {
        this.diagnosticMessageResult = diagnosticMessageResult;
        this.diagnosticInfo = diagnosticInfo;
    }

    public TransmissionImpl(String diagnosticInfo, Connection connection) {
        this.diagnosticInfo = diagnosticInfo;
        this.connection = connection;
    }

    public String getDiagnosticMessageResult() {
        return diagnosticMessageResult;
    }

    public void setDiagnosticMessageResult(String diagnosticMessageResult) {
        this.diagnosticMessageResult = diagnosticMessageResult;
    }

    public Random getConnectionEventsSimulator() {
        return connectionEventsSimulator;
    }

    public String getDiagnosticChannelConnectionString() {
        return DiagnosticChannelConnectionString;
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void send(String message)
    {
        if (message == null || "".equals(message))
        {
            throw new IllegalArgumentException();
        }

        if (message == DIAGNOSTIC_MESSAGE)
        {
            // simulate a status report
            diagnosticMessageResult =
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

            return;
        }

        // here should go the real Send operation (not needed for this exercise)
    }

    public String receive()
    {
        String message;

        if (diagnosticMessageResult == null || "".equals(diagnosticMessageResult))
        {
            // simulate a received message (just for illustration - not needed for this exercise)
            message = "";
            int messageLength = connectionEventsSimulator.nextInt(50) + 60;
            for(int i = messageLength; i >=0; --i)
            {
                message += (char)connectionEventsSimulator.nextInt(40) + 86;
            }

        }
        else
        {
            message = diagnosticMessageResult;
            diagnosticMessageResult = "";
        }

        return message;
    }
    public void checkTransmission() throws Exception
    {
        diagnosticInfo = "";

        connection.disconnect();

        int retryLeft = 3;
        while (connection.getOnlineStatus() == false && retryLeft > 0)
        {
            connection.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if(connection.getOnlineStatus() == false)
        {
            throw new Exception("Unable to connect.");
        }

        send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = receive();
    }
}
