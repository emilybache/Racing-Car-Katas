package tddmicroexercises.telemetrysystem;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static tddmicroexercises.telemetrysystem.TelemetryClient.DIAGNOSTIC_MESSAGE;

public class TelemetryClientTest {
    ConnectionClass connection = new ConnectionClass();
    ClientClass client = new ClientClass();

    boolean onlineStatus;
    @Test
    void testConnection(){
        connection.connect("connectionstring");
        Assert.assertEquals(false,onlineStatus);
    }
    @Test
    void testDisconnection(){
        connection.disconnect();
        Assert.assertEquals(false, onlineStatus);
    }
    @Test
    void testSend(){
        client.send("AT#UD");
        Assert.assertEquals("AT#UD",DIAGNOSTIC_MESSAGE);
    }
    @Test
    void testReceive(){
       String msg=  client.receive();
       Assert.assertNotEquals(msg,client.receive());

    }
    @Test
    void testGetOnlineStatus(){
       onlineStatus= client.getOnlineStatus();
       Assert.assertEquals(onlineStatus,client.getOnlineStatus());
    }

}
