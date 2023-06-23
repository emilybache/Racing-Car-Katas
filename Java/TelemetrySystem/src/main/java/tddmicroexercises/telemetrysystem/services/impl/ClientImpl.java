package tddmicroexercises.telemetrysystem.services.impl;

import java.util.Random;
import tddmicroexercises.telemetrysystem.services.Client;

public class ClientImpl implements Client {
    private static boolean onlineStatus;
    private static String diagnosticMessageResult = "";
    private Random connectionEventsSimulator = new Random(42L);

    public ClientImpl() {
    }

    public boolean getOnlineStatus() {
        return onlineStatus;
    }

    public void send(String message) {
        if (message != null && !"".equals(message)) {
            if (message == "AT#UD") {
                diagnosticMessageResult = "LAST TX rate................ 100 MBPS\r\nHIGHEST TX rate............. 100 MBPS\r\nLAST RX rate................ 100 MBPS\r\nHIGHEST RX rate............. 100 MBPS\r\nBIT RATE.................... 100000000\r\nWORD LEN.................... 16\r\nWORD/FRAME.................. 511\r\nBITS/FRAME.................. 8192\r\nMODULATION TYPE............. PCM/FM\r\nTX Digital Los.............. 0.75\r\nRX Digital Los.............. 0.10\r\nBEP Test.................... -5\r\nLocal Rtrn Count............ 00\r\nRemote Rtrn Count........... 00";
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String receive() {
        String message;
        if (diagnosticMessageResult != null && !"".equals(diagnosticMessageResult)) {
            message = diagnosticMessageResult;
            diagnosticMessageResult = "";
        } else {
            message = "";
            int messageLength = this.connectionEventsSimulator.nextInt(50) + 60;

            for(int i = messageLength; i >= 0; --i) {
                message = message + ((char)this.connectionEventsSimulator.nextInt(40) + 86);
            }
        }

        return message;
    }
}

