
Alarm = function() {

	this._lowPressureTreshold = 17;
	this._highPressureTreshold = 21;
	this._sensor = new Sensor();
	this._alarmOn = false;
};

Alarm.prototype = {

	check: function () {
		
		var psiPressureValue = this._sensor.popNextPressurePsiValue();

		if (psiPressureValue < this._lowPressureTreshold || this._highPressureTreshold < psiPressureValue)
		{
			this._alarmOn = true;
		}
	},
	
	alarmOn: function () {
		 return this._alarmOn;
	}

};
