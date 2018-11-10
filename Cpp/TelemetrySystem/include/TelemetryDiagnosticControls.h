#pragma once

#include "TelemetryClient.h"

#include <string>

class TelemetryDiagnosticControls
{
    std::string m_diagnosticChannelConnectionString;
    TelemetryClient m_telemetryClient;
    std::string m_diagnosticInfo;

public: 
    TelemetryDiagnosticControls();
        
    std::string getDiagnosticInfo();
    
    void setDiagnosticInfo(std::string const& diagnosticInfo);
 
    void checkTransmission();
};
