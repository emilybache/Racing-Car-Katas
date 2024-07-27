using System;
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
            public void Disconnect()
            {
                // Arrange
                var telemetryClientMock = new Mock<ITelemetryClient>();
                var telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClientMock.Object);

                // Act
                try
                {
                    telemetryDiagnosticControls.CheckTransmission();
                }
                catch
                {
                    // ignored
                }

                // Assert
                telemetryClientMock.Verify(x => x.Disconnect(), Times.Once);
            }

            [Fact]
            public void Try_to_connect_at_max_thrice()
            {
                // Arrange
                var telemetryClientMock = new Mock<ITelemetryClient>();
                var telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClientMock.Object);

                // Act
                try
                {
                    telemetryDiagnosticControls.CheckTransmission();
                }
                catch
                {
                    // ignored
                }

                // Assert
                telemetryClientMock.Verify(x => x.Connect(It.IsAny<string>()), Times.Exactly(3));
            }

            [Fact]
            public void Throw_exception_when_unable_to_connect()
            {
                // Arrange
                var telemetryClientMock = new Mock<ITelemetryClient>();
                telemetryClientMock.Setup(x => x.IsConnected()).Returns(false);
                var telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClientMock.Object);

                // Act
                var exception = Assert.Throws<Exception>(() => telemetryDiagnosticControls.CheckTransmission());

                // Assert
                Assert.Equal("Unable to connect.", exception.Message);
            }
        }
    }
}
