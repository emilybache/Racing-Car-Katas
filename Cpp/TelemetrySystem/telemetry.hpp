#include <string>
#include <vector>

using namespace std;

class TelemetryClient
{
public:
    TelemetryClient();
    bool getOnlineStatus();
    void connect(string &address);
    void disconnect();
    void send(string &message);
    string receive();
    
protected:
    bool onlineStatus;
    string diagnosticMessageResult;
};

class TelemetryDiagnostics
{
public:
    TelemetryDiagnostics();
    string getDiagnosticInfo();
    void checkTransmission();

protected:
    string diagnosticInfo;
    TelemetryClient telemetryClient;
};

