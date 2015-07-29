require_relative '../telemetry'

describe TelemetryDiagnostics do
  context "#diagnostic_info" do
    it "returns the correct diagnostic info" do
      expect(TelemetryDiagnostics.new.diagnostic_info).to eq "foo"
    end
  end
end
