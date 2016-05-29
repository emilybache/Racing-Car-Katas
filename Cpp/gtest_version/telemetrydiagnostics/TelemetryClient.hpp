
#include <string>
#include <random>

class TelemetryClient
{
    bool m_onlineStatus;
    std::string m_diagnosticMessageResult;
    std::seed_seq m_seed;
    std::mt19937 m_generator;

public:
    static std::string const DIAGNOSTIC_MESSAGE;
    
    TelemetryClient();

    bool getOnlineStatus();

    void connect(std::string const& telemetryServerConnectionString);

    void disconnect();

    void send(std::string const& message);

    std::string receive();
};
