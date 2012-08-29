import random

class TelemetryClient(object):
    DIAGNOSTIC_MESSAGE = "AT#UD"

    def __init__(self):
        self.onlineStatus = False
        self.diagnosticMessageResult = ""

    def getOnlineStatus(self):
        return self.onlineStatus 

    def connect(self, telemetryServerConnectionString):
        if (telemetryServerConnectionString is None or telemetryServerConnectionString == ""):
            raise IllegalArgumentException()

        # simulate the operation on a real modem
        success = random.randint(0, 10) <= 8

        self.onlineStatus = success

    def disconnect(self):
        self.onlineStatus = false

    def send(self, message):
        if (message is None or message == ""):
            raise IllegalArgumentException()

        if (message == TelemetryClient.DIAGNOSTIC_MESSAGE):
            # simulate a status report
            self.diagnosticMessageResult = """\
LAST TX rate................ 100 MBPS\r\n
HIGHEST TX rate............. 100 MBPS\r\n
LAST RX rate................ 100 MBPS\r\n
HIGHEST RX rate............. 100 MBPS\r\n
BIT RATE.................... 100000000\r\n
WORD LEN.................... 16\r\n
WORD/FRAME.................. 511\r\n
BITS/FRAME.................. 8192\r\n
MODULATION TYPE............. PCM/FM\r\n
TX Digital Los.............. 0.75\r\n
RX Digital Los.............. 0.10\r\n
BEP Test.................... -5\r\n
Local Rtrn Count............ 00\r\n
Remote Rtrn Count........... 00"""

            return
        # here should go the real Send operation

    def receive(self):
        if (self.diagnosticMessageResult is None or self.diagnosticMessageResult == ""):
            # simulate a received message
            message = ""
            messageLength = random.randint(0, 50) + 60
            i = messageLength
            while(i >= 0):
                message += chr((random.randint(0, 40) + 86))
                i -= 1
        else:
            message = self.diagnosticMessageResult
            self.diagnosticMessageResult = ""

        return message

class TelemetryDiagnosticControls:
    DiagnosticChannelConnectionString = "*111#"

    def __init__(self):
        self.telemetryClient = TelemetryClient()
        self.diagnosticInfo = ""

    def getDiagnosticInfo(self):
    	return self.diagnosticInfo

    def setDiagnosticInfo(self, diagnosticInfo):
    	self.diagnosticInfo = diagnosticInfo

    def checkTransmission(self):
        self.diagnosticInfo = ""

        self.telemetryClient.disconnect()

        retryLeft = 3
        while (self.telemetryClient.getOnlineStatus() == False and retryLeft > 0):
            self.telemetryClient.connect(TelemetryDiagnosticControls.DiagnosticChannelConnectionString)
            retryLeft -= 1
        

        if telemetryClient.getOnlineStatus() == False:
            raise Exception("Unable to connect.")

        self.telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE)
        self.diagnosticInfo = self.telemetryClient.receive()


