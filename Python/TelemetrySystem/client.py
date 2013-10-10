import random

class TelemetryClient(object):

    # The communication with the server is simulated in this implementation.
    # Because the focus of the exercise is on the other class.

    DIAGNOSTIC_MESSAGE = "AT#UD"

    def __init__(self):
        self._online_status = False
        self._diagnosticMessageJustSent = False

    @property
    def online_status(self):
        return self._online_status

    def connect(self, telemetry_server_connection_string):
        if (telemetry_server_connection_string is None or telemetry_server_connection_string == ""):
            raise Exception()

        # Fake the connection with 20% chances of success
        success = random.randint(1, 10) <= 2

        self._online_status = success

    def disconnect(self):
        self._online_status = False

    def send(self, message):
        if (message is None or message == ""):
            raise Exception()

        # The simulation of Send() actually just remember if the last message sent was a diagnostic message.
        # This information will be used to simulate the Receive(). Indeed there is no real server listening.
        if (message == TelemetryClient.DIAGNOSTIC_MESSAGE):
            self._diagnosticMessageJustSent = True
        else:
            self._diagnosticMessageJustSent = False


    def receive(self):
        if (self._diagnosticMessageJustSent):
            # Simulate the reception of the diagnostic message
            message = """\
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
            self._diagnosticMessageJustSent = False
        else:
            #  Simulate the reception of a response message returning a random message.
            message = ""
            messageLength = random.randint(0, 50) + 60
            i = messageLength
            while(i >= 0):
                message += chr((random.randint(0, 40) + 86))
                i -= 1

        return message
