
import random

class Sensor(object):
    OFFSET = 16
        
    def pop_next_pressure_psi_value(self):
        pressure_telemetry_value = self.sample_pressure()
        return Sensor.OFFSET + pressure_telemetry_value

    @staticmethod
    def sample_pressure():
        # placeholder implementation that simulate a real sensor in a real tire
        pressure_telemetry_value = 6 * random.random() * random.random()
        return pressure_telemetry_value


class Alarm(object):

    def __init__(self):
        self.low_pressure_threshold = 17
        self.high_pressure_threshold = 21
        self.sensor = Sensor()
        self.alarm_on = False
        self.alarm_count = 0

    def check(self):
        psi_pressure_value = self.sensor.pop_next_pressure_psi_value()
        if psi_pressure_value < self.low_pressure_threshold or self.high_pressure_threshold < psi_pressure_value:
            self.alarm_on = True
            self.alarm_count += 1

    def is_alarm_on(self):
        return self.alarm_on 
