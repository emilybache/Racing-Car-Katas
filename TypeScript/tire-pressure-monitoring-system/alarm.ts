import Sensor from './sensor';
import SensorInterface from './sensor-interface';

export default class Alarm {
	public static HIGH_PRESSURE_THRESHOLD: number = 21;
	public static LOW_PRESSURE_THRESHOLD: number = 17;

	private sensor: SensorInterface;
	private alarmOn: boolean = false;

	constructor(sensor?: SensorInterface) {
		this.sensor = sensor ?? new Sensor();
	}

	public check(): Alarm {
		const psiPressureValue = this.sensor.popNextPressurePsiValue();

		this.alarmOn = psiPressureValue < Alarm.LOW_PRESSURE_THRESHOLD
								|| psiPressureValue > Alarm.HIGH_PRESSURE_THRESHOLD

		return this
	}

	public isAlarmOn() {
		return this.alarmOn;
	}

}
