use tire_pressure_monitoring_system::{Alarm, Sensor};

#[test]
fn foo() {
    let alarm = Alarm::new();
    assert_eq!(alarm.is_alarm_on(), false);
}
