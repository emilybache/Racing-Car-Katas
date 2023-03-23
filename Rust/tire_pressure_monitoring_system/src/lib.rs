pub mod tire_pressure_monitoring_system {
    use rand::Rng;

    pub struct Alarm {
        low_pressure_threshold: f64,
        high_pressure_threshold: f64,
        sensor: Sensor,
        alarm_on: bool,
    }

    impl Alarm {
        pub fn new() -> Self {
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

    pub struct Sensor {
        offset: f64,
    }

    impl Sensor {
        pub fn new() -> Self {
            Sensor { offset: 16.0 }
        }

        pub fn pop_next_pressure_psi_value(&self) -> f64 {
            let pressure_telemetry_value = Self::sample_pressure();
            self.offset + pressure_telemetry_value
        }

        fn sample_pressure() -> f64 {
            let mut rng = rand::thread_rng();
            let pressure_telemetry_value = 6.0 * rng.gen::<f64>() * rng.gen::<f64>();
            pressure_telemetry_value
        }
    }

    #[cfg(test)]
    mod tests {
        use super::{Alarm};

        #[test]
        fn test_alarm() {
            let mut alarm = Alarm::new();
            assert_eq!(false, alarm.is_alarm_on());
        }
    }
}
