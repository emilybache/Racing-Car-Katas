package tddmicroexercises.tirepressuremonitoringsystem

import java.util.Random

// The reading of the pressure value from the sensor is simulated in this implementation.
// Because the focus of the exercise is on the other class.

class Sensor {

     def popNextPressurePsiValue() : Double = {
        var pressureTelemetryValue : Double = 0
        pressureTelemetryValue = Sensor.samplePressure()

        return Sensor.OFFSET + pressureTelemetryValue
    }

}

object Sensor  {

  val OFFSET :  Double = 16

  private def samplePressure() : Double = {
         // placeholder implementation that simulate a real sensor in a real tire
         val basicRandomNumbersGenerator = new Random()
         val pressureTelemetryValue = 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble()
         return pressureTelemetryValue
     }
}