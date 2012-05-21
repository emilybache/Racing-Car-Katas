TelemetryClientConnection = function() {

	this._onlineStatus = false;
	
};



TelemetryClientConnection.prototype = {

	// simulate the operation on a real modem
	_connectionEventsSimulator: function (min, max) {
		var delta = max + 1 - min;
		return min + Math.floor(delta * Math.random());
	},

	onlineStatus: function () {
		return this._onlineStatus;
	},
	
	connect: function(telemetryServerConnectionString) {
			if (typeof(telemetryServerConnectionString) === 'undefined' || telemetryServerConnectionString === '') {
				throw 'missing telemetryServerConnectionString parameter';
			}

			// simulate the operation on a real modem
			var success = this._connectionEventsSimulator(1, 10) <= 8;

			this._onlineStatus = success;
	},
	
	disconnect: function () {
		this._onlineStatus = false;
	}

};
