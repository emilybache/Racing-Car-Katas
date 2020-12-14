export default class TelemetryClient {

	private onlineStatus: boolean;
	private diagnosticMessageResult: string;

	constructor() {
		this.onlineStatus = false;
		this.diagnosticMessageResult = '';
	}

	public diagnosticMessage() {
		return 'AT#UD';
	}

	public getOnlineStatus() {
		return this.onlineStatus;
	}

	public connect(telemetryServerConnectionString: string) {
		if (telemetryServerConnectionString === '') {
			throw new Error('missing telemetryServerConnectionString parameter');
		}

		// simulate the operation on a real modem
		const success = this.connectionEventsSimulator(1, 10) <= 8;

		this.onlineStatus = success;
	}

	public disconnect() {
		this.onlineStatus = false;
	}

	public send(message: string) {
		if (message === '') {
			throw new Error('missing message parameter');
		}

		if (message === this.diagnosticMessage()) {
			// simulate a status report
			this.diagnosticMessageResult =
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

	public receive() {
		let message;

		if (this.diagnosticMessageResult === '') {

			// simulate a received message (just for illustration - not needed for this exercise)
			message = '';
			const messageLength = this.connectionEventsSimulator(50, 110);
			for (let i = messageLength; i >= 0; --i) {
				message += this.connectionEventsSimulator(40, 126).toString();
			}
		} else {
			message = this.diagnosticMessageResult;
			this.diagnosticMessageResult = '';
		}

		return message;
	}

	// simulate the operation on a real modem
	private connectionEventsSimulator(min: number, max: number): number {
		const delta = max + 1 - min;
		return min + Math.floor(delta * Math.random());
	}

}
