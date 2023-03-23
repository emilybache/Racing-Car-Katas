use rand::Rng;

pub struct Sensor {
    offset: f64,
}

impl Sensor {
    pub fn new() -> Sensor {
        Sensor { offset: 16.0 }
    }

    pub fn pop_next_pressure_psi_value(&self) -> f64 {
        let pressure_telemetry_value = Self::sample_pressure();
        self.offset + pressure_telemetry_value
    }

    fn sample_pressure() -> f64 {
        let mut rng = rand::thread_rng();
        6.0 * rng.gen::<f64>() * rng.gen::<f64>()
    }
}
