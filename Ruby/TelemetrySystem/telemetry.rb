require './client'

class TelemetryDiagnostics
  attr_reader :diagnostic_info
  DIAGNOSTIC_CHANNEL_CONNECTION_STRING = "*111#"
  
  def initialize
    @telemetry_client = TelemetryClient.new
    @diagnostic_info = ""
  end

  def check_transmission
    @diagnostic_info = ""
    @telemetry_client.disconnect

    retry_left = 3
    while (not @telemetry_client.online_status) and retry_left > 0
      @telemetry_client.connect(DIAGNOSTIC_CHANNEL_CONNECTION_STRING)
      retry_left -= 1
    end

    if not @telemetry_client.online_status
      raise Exception.new("Unable to connect.")
    end

    @telemetry_client.send(TelemetryClient::DIAGNOSTIC_MESSAGE)
    @diagnostic_info = @telemetry_client.receive
  end
end
