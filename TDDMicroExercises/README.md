# TDD micro-exercises

## Instructions

Here follow 4 distinct problems. They could be code you inherited from a legacy code-base. Now you want to write unit tests for them, and to do so you will need to do some refactoring. Take care when refactoring not to change interfaces which client code may rely on. Apply the unit testing style and framework you are most comfortable with. You can choose to use stubs or mocks or none at all. If you do, you are free to use the mocking tool that you prefer.

1. **TirePressureMonitoringSystem exercise**:  write the unit tests for the Alarm class, refactor the code as much as you need to make the class testable

The Alarm class is designed to monitor tire pressure and set an alarm if the pressure falls outside of the expected range. The Sensor class provided for the exercise fakes the behaviour of a real tire sensor, providing random but realistic values.

2. **UnicodeFileToHtmTextConverter exercise**: write the unit tests for the UnicodeFileToHtmTextConverter class, refactor the code as much as you need to make the class testable.

The UnicodeFileToHtmTextConverter class is designed to reformat a plain text file for display in a browser.

3. **TelemetrySystem exercise**: write the unit tests for the TelemetryDiagnosticControls class, refactor the code as much as you need to make the class testable.

The responsibility of the TelemetryDiagnosticControls class is to establish a connection to the telemetry server (through the TelemetryClient), send a diagnostic request and successfully receive the response that contains the diagnostic info. The TelemetryClient class provided for the exercise fakes the behavior of the real TelemetryClient class, and can respond with either the diagnostic information or a random sequence. The real TelemetryClient class would connect and communicate with the telemetry server via tcp/ip.

4. **TicketDispenser exercise**: write the unit tests for the TicketDispenser, refactor the code as much as you need to make the class testable

The TicketDispenser class is designed to be used to manage a queuing system in a shop. There may be more than one ticket dispenser but the same ticket should not be issued to two different customers.


## After you've had a go yourself

Here you find possible solutions for the exercises: [proposed solution.] (https://github.com/emilybache/TDDwithMockObjectsAndDesignPrinciples/tree/master/TDDMicroExercises.ProposedSolution) 
Feel free to send your comments and questions.

