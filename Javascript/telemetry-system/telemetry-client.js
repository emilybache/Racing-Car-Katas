var DataHelper = require('./data-helper.js')

TelemetryClient = function() {

	this._onlineStatus = false;
	this._diagnosticMessageResult = '';
};

TelemetryClient.prototype = {

	onlineStatus: function() {
		return this._onlineStatus;
	},

	connect: function(telemetryServerConnectionString) {
		if (typeof (telemetryServerConnectionString) === 'undefined' || telemetryServerConnectionString === '') {
			throw 'missing telemetryServerConnectionString parameter';
		}

		// simulate the operation on a real modem
		var success = DataHelper._connectionEventsSimulator(1, 10) <= 8;

		this._onlineStatus = success;
	},

	disconnect: function() {
		this._onlineStatus = false;
	},

	
};

module.exports = TelemetryClient;
