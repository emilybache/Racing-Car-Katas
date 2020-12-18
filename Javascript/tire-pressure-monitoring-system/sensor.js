// The reading of the pressure value from the sensor is simulated in this implementation.
// Because the focus of the exercise is on the other class.

Sensor = function() {

	Sensor.Offset = function() { return 16; };

	Sensor.samplePressure = function() {
		// placeholder implementation that simulate a real sensor in a real tire
		var pressureTelemetryValue = Math.floor(6 * Math.random() * Math.random());
		return pressureTelemetryValue;
	};
};

Sensor.prototype = {

	popNextPressurePsiValue: function() {
		var pressureTelemetryValue = Sensor.samplePressure();

		return Sensor.Offset() + pressureTelemetryValue;
	}
};

module.exports = Sensor;
