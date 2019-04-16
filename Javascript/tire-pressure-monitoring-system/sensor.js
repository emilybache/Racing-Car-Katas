
Sensor = function() {

	Sensor.Offset = function() { return 16; };
	Sensor.SamplePressure = function() {
		// placeholder implementation that simulate a real sensor in a real tire

		var pressureTelemetryValue = Math.floor(6 * Math.random() * Math.random());
		return pressureTelemetryValue;
	};
};

Sensor.prototype = {

	popNextPressurePsiValue: function () {
		var pressureTelemetryValue = Sensor.SamplePressure();

		return Sensor.Offset() + pressureTelemetryValue;
	}
};

module.exports = { Sensor };
