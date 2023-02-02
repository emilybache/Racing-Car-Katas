const chai = require("chai");
const sinon = require("sinon");
const expect = chai.expect;
const TelemetryDiagnosticControls = require('../telemetry-system/telemetry-diagnostic-controls.js')
const TelemetryClient = require('../telemetry-system/telemetry-client')

describe("TelemetryDiagnosticControls", ()  => {

    it("should be hold valid string info", async() => {
        let _diagnosticInfo = "sdfsd";
        expect(_diagnosticInfo).to.not.equal(null)
    })

    it("should be return false/true for online status", async() => {
        const stubTelemetryClientOnlineStatus = sinon.stub(TelemetryClient, 'onlineStatus').returns(false)
        const stubValue = TelemetryClient.onlineStatus
        expect(TelemetryClient.onlineStatus).to.equal(undefined)
    })

    // it("should be throw error for online status false and try will be zero", async() => {
    //     const stubTelemetryClientOnlineStatus = sinon.stub(TelemetryClient, 'onlineStatus').throwsException("Unable to connect")
    //     const stubValue = TelemetryClient.onlineStatus
    //     console.log("Unable to connect", stubValue)
    //     expect(TelemetryClient.onlineStatus).to.equal(false)
    // })
    
})