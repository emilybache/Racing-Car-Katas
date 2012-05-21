describe('Telemetry System', function () {

	describe('TelemetryDiagnosticControls', function () {

		it('CheckTransmission() should send a diagnostic message and receive a status message response', function () {

			var mockTelemetryDataChannel = a.mock(TelemetryDataChannel);
			spyOn(mockTelemetryDataChannel, 'send');
			spyOn(mockTelemetryDataChannel, 'receive');
			var stubTelemetryConnection = a.stub(TelemetryClientConnection);

			var target = new TelemetryDiagnosticControls(stubTelemetryConnection, mockTelemetryDataChannel);
			target.checkTransmission();

			expect(mockTelemetryDataChannel.send).toHaveBeenCalledWith(TelemetryDataChannel.diagnosticMessage());
			expect(mockTelemetryDataChannel.receive).toHaveBeenCalled();
			
		});

	});

});
