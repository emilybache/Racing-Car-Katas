import random

class TelemetryClient(object):
    DIAGNOSTIC_MESSAGE = "AT#UD"

    def __init__(self):
        self.online_status = False
        self.diagnostic_message_result = ""

    def get_online_status(self):
        return self.online_status

    def connect(self, telemetry_server_connection_string):
        if (telemetry_server_connection_string is None or telemetry_server_connection_string == ""):
            raise Exception()

        # simulate the operation on a real modem
        success = random.randint(0, 10) <= 8

        self.online_status = success

    def disconnect(self):
        self.online_status = False

    def send(self, message):
        if (message is None or message == ""):
            raise Exception()

        if (message == TelemetryClient.DIAGNOSTIC_MESSAGE):
            # simulate a status report
            self.diagnostic_message_result = """\
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
        if (self.diagnostic_message_result is None or self.diagnostic_message_result == ""):
            # simulate a received message
            message = ""
            messageLength = random.randint(0, 50) + 60
            i = messageLength
            while(i >= 0):
                message += chr((random.randint(0, 40) + 86))
                i -= 1
        else:
            message = self.diagnostic_message_result
            self.diagnostic_message_result = ""

        return message

class TelemetryDiagnosticControls:
    DiagnosticChannelConnectionString = "*111#"

    def __init__(self):
        self.telemetry_client = TelemetryClient()
        self.diagnostic_info = ""

    def check_transmission(self):
        self.diagnostic_info = ""

        self.telemetry_client.disconnect()

        retryLeft = 3
        while (self.telemetry_client.get_online_status() == False and retryLeft > 0):
            self.telemetry_client.connect(TelemetryDiagnosticControls.DiagnosticChannelConnectionString)
            retryLeft -= 1

        if telemetry_client.get_online_status() == False:
            raise Exception("Unable to connect.")

        self.telemetry_client.send(TelemetryClient.DIAGNOSTIC_MESSAGE)
        self.diagnostic_info = self.telemetry_client.receive()


