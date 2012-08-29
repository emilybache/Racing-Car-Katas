
import random

class Sensor(object):
    OFFSET = 16
        
    def popNextPressurePsiValue(self):
        pressureTelemetryValue = self.samplePressure()
        return Sensor.OFFSET + pressureTelemetryValue

    @staticmethod
    def samplePressure():
        # placeholder implementation that simulate a real sensor in a real tire
        pressureTelemetryValue = 6 * random.random() * random.random()
        return pressureTelemetryValue


class Alarm(object):
    
    def __init__(self):
        self.low_pressure_threshold = 17
        self.high_pressure_threshold = 21
        self.sensor = Sensor()
        self.alarmOn = False
        self.alarmCount = 0

    def check(self):
        psiPressureValue = self.sensor.popNextPressurePsiValue()
        if psiPressureValue < self.low_pressure_threshold or self.high_pressure_threshold < psiPressureValue:
            self.alarmOn = True
            self.alarmCount += 1

    def isAlarmOn(self):
        return self.alarmOn 
