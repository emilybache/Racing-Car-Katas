var DataHelper = require('./data-helper')

class TelemetryOperation {

    // constructor(){
    //     this._diagnosticMessageResult = ''
    // }

    diagnosticMessage(){
        return 'AT#UD';
    }

    send(message) {
		if (typeof (message) === 'undefined' || message === '') {
			throw 'missing message parameter';
		}

		if (message === this.diagnosticMessage()) {
			// simulate a status report
			this._diagnosticMessageResult =
				'LAST TX rate................ 100 MBPS\r\n'
				+ 'HIGHEST TX rate............. 100 MBPS\r\n'
				+ 'LAST RX rate................ 100 MBPS\r\n'
				+ 'HIGHEST RX rate............. 100 MBPS\r\n'
				+ 'BIT RATE.................... 100000000\r\n'
				+ 'WORD LEN.................... 16\r\n'
				+ 'WORD/FRAME.................. 511\r\n'
				+ 'BITS/FRAME.................. 8192\r\n'
				+ 'MODULATION TYPE............. PCM/FM\r\n'
				+ 'TX Digital Los.............. 0.75\r\n'
				+ 'RX Digital Los.............. 0.10\r\n'
				+ 'BEP Test.................... -5\r\n'
				+ 'Local Rtrn Count............ 00\r\n'
				+ 'Remote Rtrn Count........... 00';

			return;
		}

		// here should go the real Send operation (not needed for this exercise)
	}

	receive() {
		var message;

		if (typeof (this._diagnosticMessageResult) === 'undefined' || this._diagnosticMessageResult === '') {

			// simulate a received message (just for illustration - not needed for this exercise)
			message = '';
			var messageLength = DataHelper._connectionEventsSimulator(50, 110);
			for (var i = messageLength; i >= 0; --i) {
				message += DataHelper._connectionEventsSimulator(40, 126).toString();
			}
		}
		else {
			message = this._diagnosticMessageResult;
			this._diagnosticMessageResult = '';
		}

		return message;
	}
}

module.exports = TelemetryOperation