const { TelemetryDiagnosticControls } = require('../telemetry-system/telemetry-diagnostic-controls.js');

describe('Telemetry System', function () {

	describe('TelemetryDiagnosticControls', function () {

		it('CheckTransmission() should send a diagnostic message and receive a status message response', function () {

			var target = new TelemetryDiagnosticControls();
			target.checkTransmission();

			var result = target.readDiagnosticInfo();

		});

	});

});
