var Sensor = require('./sensor.js');

Alarm = function() {
	this._lowPressureThreshold = 17;
	this._highPressureThreshold = 21;
	this._sensor = new Sensor();
	this._alarmOn = false;
};

Alarm.prototype = {

	check: function() {
		var psiPressureValue = this._sensor.popNextPressurePsiValue();

		if (psiPressureValue < this._lowPressureThreshold || this._highPressureThreshold < psiPressureValue) {
			this._alarmOn = true;
		}
	},

	alarmOn: function() {
		return this._alarmOn;
	}

};

module.exports = Alarm;
