using Moq;
using Xunit;

namespace TDDMicroExercises.TelemetrySystem.Tests
{
    public class TelemetryDiagnosticControlShould
    {
        public class CtorShould
        {
            [Fact]
            public void Set_the_telemetry_client()
            {
                // Arrange
                var telemetryClientMock = new Mock<ITelemetryClient>();

                // Act
                var telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClientMock.Object);

                // Assert
                Assert.Same(telemetryClientMock.Object, telemetryDiagnosticControls.TelemetryClient);
            }
        }

        public class CheckTransmissionShould
        {
            [Fact]
            public void Send_a_diagnostic_message_when_connected()
            {
                // Arrange
                var telemetryClientMock = new Mock<ITelemetryClient>();
                var telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClientMock.Object);
                telemetryClientMock.Setup(x => x.IsConnected()).Returns(true);

                // Act
                telemetryDiagnosticControls.CheckTransmission();

                // Assert
                telemetryClientMock.Verify(x => x.Send(TelemetryClient.DiagnosticMessage), Times.Once);
            }
        }
    }
}
