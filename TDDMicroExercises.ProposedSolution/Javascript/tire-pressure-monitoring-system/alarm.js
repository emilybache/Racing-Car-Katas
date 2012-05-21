
Alarm = function(sensor) {

	this._lowPressureTreshold = 17;
	this._highPressureTreshold = 21;
	this._sensor = sensor;
	this._alarmOn = false;
	this._alarmCount = 0;
};

Alarm.Create = function() {
	return new Alarm(new Sensor());
};

Alarm.prototype = {

	check: function () {
		
		var psiPressureValue = this._sensor.popNextPressurePsiValue();

		if (psiPressureValue < this._lowPressureTreshold || this._highPressureTreshold < psiPressureValue)
		{
			this._alarmOn = true;
			this._alarmCount += 1;
		}
	},
	
	alarmOn: function () {
		 return this._alarmOn;
	}

};
