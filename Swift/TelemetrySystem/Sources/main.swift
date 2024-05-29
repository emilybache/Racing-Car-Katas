// The Swift Programming Language
// https://docs.swift.org/swift-book

let diagnosticControls = TelemetryDiagnosticControls()

do {
    print("Checking transmission")
    try diagnosticControls.checkTransmission()
    print(diagnosticControls.diagnosticInfo)
} catch {
    print(error)
}
