class StubAlarm(object):
    
    def __init__(self, alarmOnReturnValue):
        self.alarmOnReturnValue = alarmOnReturnValue

    def setAlarmOn(self, returnValue):
        self.alarmOnReturnValue = returnValue

    def check(self):
        pass

    def isAlarmOn(self):
        return self.alarmOnReturnValue
        

class MockAlarm(object):

    def __init__(self):
        self.alarmOn = False
        
        self.expectedCheckCallsCount = 0
        self.actualCheckCallsCount = 0
        
        self.expectedAlarmOnCallsCount = 0
        self.actualAlarmOnCallsCount = 0

    def resetExpectedCallsCount(self):
        self.expectedCheckCallsCount = 1

    def resetAlarmToOn(self):
        self.expectedAlarmOnCallsCount = 1
        self.alarmOn = true    

    def verify(self):
        if self.expectedAlarmOnCallsCount != self.actualAlarmOnCallsCount:
            #TODO - find a more appropriate exception
            raise RuntimeError("AlarmOn calls count: %s expected: %s " % (self.actualAlarmOnCallsCount, self.expectedAlarmOnCallsCount))
        if self.expectedCheckCallsCount != self.actualCheckCallsCount:
            raise RuntimeError("Check calls count: %s expected: %s" %  (self.actualCheckCallsCount, self.expectedCheckCallsCount))

    def check(self):
        self.actualCheckCallsCount += 1

    def isAlarmOn(self):
        self.actualAlarmOnCallsCount += 1
        return self.alarmOn



