
#include "../include/TelemetryDiagnosticControls.h"

#include <stdexcept>

TelemetryDiagnosticControls::TelemetryDiagnosticControls() : 
     m_diagnosticChannelConnectionString( "*111#" )
    ,m_telemetryClient()
    ,m_diagnosticInfo()
{}
    
std::string TelemetryDiagnosticControls::getDiagnosticInfo()
{
    return m_diagnosticInfo;
}

void TelemetryDiagnosticControls::setDiagnosticInfo(std::string const& diagnosticInfo)
{
    m_diagnosticInfo = diagnosticInfo;
}

void TelemetryDiagnosticControls::checkTransmission() 
{
    m_diagnosticInfo = "";

    m_telemetryClient.disconnect();

    int retryLeft = 3;
    while (m_telemetryClient.getOnlineStatus() == false && retryLeft > 0)
    {
        m_telemetryClient.connect(m_diagnosticChannelConnectionString);
        retryLeft -= 1;
    }
     
    if(m_telemetryClient.getOnlineStatus() == false)
    {
        throw std::invalid_argument("Unable to connect");
    }

    m_telemetryClient.send(TelemetryClient::DIAGNOSTIC_MESSAGE);
    m_diagnosticInfo = m_telemetryClient.receive();
}
    