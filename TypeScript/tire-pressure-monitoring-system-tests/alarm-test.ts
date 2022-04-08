import { expect } from 'chai';
import 'mocha';
import Alarm from '../tire-pressure-monitoring-system/alarm';
import SensorInterface from '../tire-pressure-monitoring-system/sensor-interface';

describe('Tyre Pressure Monitoring System', () => {

	describe('Alarm', () => {

		it('Test Alarm Should be on when psi too high', () => {
			const alarm = new Alarm(getSensor(Alarm.HIGH_PRESSURE_THRESHOLD + 1));
			expect(alarm.check().isAlarmOn()).eql(true);
		});

		it('Test Alarm Should be on when psi too low', () => {
			const alarm = new Alarm(getSensor(Alarm.LOW_PRESSURE_THRESHOLD - 1));
			expect(alarm.check().isAlarmOn()).eql(true);
		});

		it('Test Alarm Should be off when psi is just below high pressure', () => {
			const alarm = new Alarm(getSensor(Alarm.HIGH_PRESSURE_THRESHOLD - 1))
			expect(alarm.check().isAlarmOn()).eql(false);
		});

		it('Test Alarm Should be off when psi is just above low pressure', () => {
			const alarm = new Alarm(getSensor(Alarm.LOW_PRESSURE_THRESHOLD + 1))
			expect(alarm.check().isAlarmOn()).eql(false);
		});

	});

});

function getSensor(pressure: Number) {
	return new class implements SensorInterface {
		public popNextPressurePsiValue() {
			return pressure;
		};
	}
}
