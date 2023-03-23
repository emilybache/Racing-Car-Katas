use crate::sensor::Sensor;

pub struct Alarm {
    low_pressure_threshold: f64,
    high_pressure_threshold: f64,
    sensor: Sensor,
    alarm_on: bool,
}

impl Alarm {
    pub fn new() -> Alarm {
        Alarm {
            low_pressure_threshold: 17.0,
            high_pressure_threshold: 21.0,
            sensor: Sensor::new(),
            alarm_on: false,
        }
    }

    pub fn check(&mut self) {
        let psi_pressure_value = self.sensor.pop_next_pressure_psi_value();

        if psi_pressure_value < self.low_pressure_threshold
            || psi_pressure_value > self.high_pressure_threshold
        {
            self.alarm_on = true;
        }
    }

    pub fn is_alarm_on(&self) -> bool {
        self.alarm_on
    }
}
