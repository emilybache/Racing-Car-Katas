class StubAlarm(object):
    
    def __init__(self, alarm_onReturnValue):
        self.alarm_onReturnValue = alarm_onReturnValue

    def set_alarm_on(self, returnValue):
        self.alarm_onReturnValue = returnValue

    def check(self):
        pass

    def is_alarm_on(self):
        return self.alarm_onReturnValue
        

class MockAlarm(object):

    def __init__(self):
        self.alarm_on = False

        self.expectedCheckCallsCount = 0
        self.actualCheckCallsCount = 0

        self.expectedAlarmOnCallsCount = 0
        self.actualAlarmOnCallsCount = 0

    def resetExpectedCallsCount(self):
        self.expectedCheckCallsCount = 1

    def resetAlarmToOn(self):
        self.expectedAlarmOnCallsCount = 1
        self.alarm_on = True

    def verify(self):
        if self.expectedAlarmOnCallsCount != self.actualAlarmOnCallsCount:
            #TODO - find a more appropriate exception
            raise RuntimeError("AlarmOn calls count: %s expected: %s " % (self.actualAlarmOnCallsCount, self.expectedAlarmOnCallsCount))
        if self.expectedCheckCallsCount != self.actualCheckCallsCount:
            raise RuntimeError("Check calls count: %s expected: %s" %  (self.actualCheckCallsCount, self.expectedCheckCallsCount))

    def check(self):
        self.actualCheckCallsCount += 1

    def is_alarm_on(self):
        self.actualAlarmOnCallsCount += 1
        return self.alarm_on



