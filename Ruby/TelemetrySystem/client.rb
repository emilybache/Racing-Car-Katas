class TelemetryClient
  attr_reader :online_status

  DIAGNOSTIC_MESSAGE = "AT#UD"
  
  def initialize
    @online_status = false
    @diagnostic_message_just_sent = false
  end

  def connect(telemetry_server_connection_string)
    if telemetry_server_connection_string.nil? or telemetry_server_connection_string == ""
      raise Exception.new
    end

    success = rand(1..10) <= 2

    @online_status = success
  end

  def disconnect
    @online_status = false
  end

  def send(message)
    if message.nil? or message == ""
      raise Exception.new
    end

    # The simulation of send() actually just remember
    # if the last message sent was a diagnostic
    # message.
    # This information will be used to simulate the
    # receive(). Indeed there is no real server
    # listening.

    if message == DIAGNOSTIC_MESSAGE
      @diagnostic_message_just_sent = true
    else
      @diagnostic_message_just_sent = false
    end
  end

  def receive
    if @diagnostic_message_just_sent
      # Simulate the reception of the diagnostic
      # message
      message = "
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
Remote Rtrn Count........... 00"
      @diagnostic_message_just_sent = false
    else
      message = ""
      message_length = rand(50) + 60
      i = message_length
      while i >= 0
        message << (rand(0..40) + 86).chr
        i -= 1
      end
    end

    return message
  end
end
