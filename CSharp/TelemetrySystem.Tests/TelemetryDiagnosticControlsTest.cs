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
    }
}
