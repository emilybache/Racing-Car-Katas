
TelemetryDiagnosticControls = function (telemetryClientConnection, telemetryDataChannel) {

	this._diagnosticChannelConnectionString = function () { return '*111#'; };
	this._diagnosticInfo = '';
	this._telemetryClientConnection = telemetryClientConnection;
	this._telemetryDataChannel = telemetryDataChannel;
};

TelemetryDiagnosticControls.Create = function () {
	return new TelemetryDiagnosticControls(new TelemetryClientConnection(), new TelemetryDataChannel());
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

		this._telemetryClientConnection.disconnect();

		var retryLeft = 3;
		while (this._telemetryClientConnection.onlineStatus() === false && retryLeft > 0) {
			this._telemetryClientConnection.connect(this._diagnosticChannelConnectionString);
			retryLeft -= 1;
		}

		if (this._telemetryClientConnection.onlineStatus() === false) {
			throw 'Unable to connect';
		}

		this._telemetryDataChannel.send(TelemetryDataChannel.diagnosticMessage());
		this._diagnosticInfo = this._telemetryDataChannel.receive();
	}
};
