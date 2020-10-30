package tddmicroexercises.telemetrysystem

import org.junit.Assert
import org.junit.Test
import java.util.*

class TelemetryClientTest {

    inner class StubRandom : Random() {
        override fun nextInt(bound: Int): Int {
            return 9
        }
    }

    @Test
    fun `Should connect successfully`() {
        val telemetryClient = TelemetryClient()
        telemetryClient.connect("testing")
        Assert.assertTrue(telemetryClient.isOnline)
    }

    @Test
    fun `Should not connect successfully`() {
        val telemetryClient = TelemetryClient(StubRandom())
        telemetryClient.connect("testing")
        Assert.assertFalse(telemetryClient.isOnline)
    }
}