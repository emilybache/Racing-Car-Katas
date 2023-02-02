var TelemetryClient = require('./telemetry-client.js');
var TelemetryOperation = require('./telemetry-operation.js');

TelemetryDiagnosticControls = function() {

	this._diagnosticChannelConnectionString = function() { return '*111#'; };

	this._telemetryClient = new TelemetryClient();
	this._diagnosticInfo = '';
};

TelemetryDiagnosticControls.prototype = {

	readDiagnosticInfo: function() {
		return this._diagnosticInfo;
	},

	writeDiagnosticInfo: function(newValue) {
		this._diagnosticInfo = newValue;
	},

	checkTransmission: function() {

		this._diagnosticInfo = '';

		this._telemetryClient.disconnect();

		var retryLeft = 3;
		while (this._telemetryClient.onlineStatus() === false && retryLeft > 0) {
			this._telemetryClient.connectStatus(this._diagnosticChannelConnectionString);
			retryLeft -= 1;
		}

		if (this._telemetryClient.onlineStatus() === false) {
			throw 'Unable to connect';
		}

		TelemetryOperation.send(TelemetryOperation.diagnosticMessage());

		this._diagnosticInfo = TelemetryOperation.receive();
	}
};

module.exports = TelemetryDiagnosticControls;
