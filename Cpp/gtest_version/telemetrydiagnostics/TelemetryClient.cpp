
#include "TelemetryClient.hpp"

#include <stdexcept>

std::string const TelemetryClient::DIAGNOSTIC_MESSAGE = "AT#UD";
    
TelemetryClient::TelemetryClient() : 
     m_onlineStatus(false)
    ,m_diagnosticMessageResult()
    ,m_seed({42})
    ,m_generator(m_seed)
{}

bool TelemetryClient::getOnlineStatus()
{
    return m_onlineStatus; 
}

void TelemetryClient::connect(std::string const& telemetryServerConnectionString)
{
    if (telemetryServerConnectionString.empty())
    {
        throw std::invalid_argument("Telemetry server connection string is empty");
    }

    // simulate the operation on a real modem
    bool success = std::uniform_int_distribution<>(0,9)(m_generator) <= 8;
    
    m_onlineStatus = success;
}

void TelemetryClient::disconnect()
{
    m_onlineStatus = false;
}

void TelemetryClient::send(std::string const& message)
{
    if (message.empty())
    {
        throw std::invalid_argument("Message to be sent is empty");
    }

    if (message == DIAGNOSTIC_MESSAGE)
    {
        // simulate a status report
        m_diagnosticMessageResult = std::string()
            + "LAST TX rate................ 100 MBPS\r\n"
            + "HIGHEST TX rate............. 100 MBPS\r\n"
            + "LAST RX rate................ 100 MBPS\r\n"
            + "HIGHEST RX rate............. 100 MBPS\r\n"
            + "BIT RATE.................... 100000000\r\n"
            + "WORD LEN.................... 16\r\n"
            + "WORD/FRAME.................. 511\r\n"
            + "BITS/FRAME.................. 8192\r\n"
            + "MODULATION TYPE............. PCM/FM\r\n"
            + "TX Digital Los.............. 0.75\r\n"
            + "RX Digital Los.............. 0.10\r\n"
            + "BEP Test.................... -5\r\n"
            + "Local Rtrn Count............ 00\r\n"
            + "Remote Rtrn Count........... 00";

        return;
    }

    // here should go the real Send operation (not needed for this exercise)
}

std::string TelemetryClient::receive()
{
    std::string message;

    if (m_diagnosticMessageResult.empty())
    {
        // simulate a received message (just for illustration - not needed for this exercise)
        message = "";
        int messageLength = std::uniform_int_distribution<>(0,49)(m_generator) + 60;
        for(int i = messageLength; i >=0; --i)
        {
            message += (char)std::uniform_int_distribution<>(0,39)(m_generator) + 86;
        }
        
    } 
    else
    {                
        message = m_diagnosticMessageResult;
        m_diagnosticMessageResult = "";
    }

    return message;
}
