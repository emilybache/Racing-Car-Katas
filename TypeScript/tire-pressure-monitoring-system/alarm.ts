import Sensor from './sensor';

export default class Alarm {
	private highPressureThreshold: number;
	private lowPressureThreshold: number;

	private sensor: Sensor;
	private alarmOn: boolean;

	constructor() {
		this.lowPressureThreshold = 17;
		this.highPressureThreshold = 21;
		this.sensor = new Sensor();
		this.alarmOn = false;
	}

	public check() {
		const psiPressureValue = this.sensor.popNextPressurePsiValue();

		if (psiPressureValue < this.lowPressureThreshold || this.highPressureThreshold < psiPressureValue) {
			this.alarmOn = true;
		}
	}

	public isAlarmOn() {
		return this.alarmOn;
	}

}
