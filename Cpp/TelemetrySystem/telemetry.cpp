#include "telemetry.hpp"

#include <cstdlib>
#include <time.h>

using namespace std;

TelemetryDiagnostics::TelemetryDiagnostics()
{
    telemetryClient = TelemetryClient();
    diagnosticInfo = "";
}

string TelemetryDiagnostics::getDiagnosticInfo()
{
    return diagnosticInfo;
}

void TelemetryDiagnostics::checkTransmission()
{
    diagnosticInfo = "";

    telemetryClient.disconnect();

    int retryLeft = 3;
    while (telemetryClient.getOnlineStatus() == false && retryLeft > 0)
    {
        string connectionString = "*111#";
        telemetryClient.connect(connectionString);
        retryLeft -= 1;
    }
     
    if(telemetryClient.getOnlineStatus() == false)
    {
        throw "Unable to connect.";
    }

    string diagnosticMessage = "AT#UD";
    telemetryClient.send(diagnosticMessage);
    diagnosticInfo = telemetryClient.receive();
}


TelemetryClient::TelemetryClient()
{
    onlineStatus = false;
    diagnosticMessageResult = "";
    srand((unsigned)time(0));
}

bool TelemetryClient::getOnlineStatus()
{
    return onlineStatus;
}

void TelemetryClient::connect(string &address) 
{
    if ("" == address)
    {
        throw "illegal address";
    }

    // simulate the operation on a real modem
    bool success = (float)rand()/((float)RAND_MAX/(10)) <= 8;

    onlineStatus = success;
}

void TelemetryClient::disconnect()
{
    onlineStatus = false;
}

void TelemetryClient::send(string &message)
{
    if ("" == message)
    {
        throw "illegal message";
    }

    if (message == "AT#UD")
    {
        /* simulate a status report */
        diagnosticMessageResult = "LAST TX rate................ 100 MBPS\r\n";
        return;
    }
}

string TelemetryClient::receive()
{
    return diagnosticMessageResult;
}

