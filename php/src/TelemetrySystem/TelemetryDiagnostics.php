<?php
declare(strict_types=1);

namespace RacingCar\TelemetrySystem;

use Exception;

class TelemetryDiagnostics
{
    public const DIAGNOSTIC_CHANNEL_CONNECTION_STRING = "*111#";

    private $telemetryClient;
    public $diagnosticInfo = "";

    public function __construct()
    {
        $this->telemetryClient = new TelemetryClient();
    }

    /**
     * @throws Exception
     */
    public function checkTransmission()
    {
        $this->diagnosticInfo = "";
        $this->telemetryClient->disconnect();

        $retryLeft = 3;
        while($this->telemetryClient->getOnlineStatus() === false and $retryLeft > 0)
        {
            $this->telemetryClient->connect(TelemetryDiagnostics::DIAGNOSTIC_CHANNEL_CONNECTION_STRING);
            $retryLeft -= 1;
        }

        if ($this->telemetryClient->getOnlineStatus() === false)
            throw new Exception("Unable to connect.");

        $this->telemetryClient->send(TelemetryClient::DIAGNOSTIC_MESSAGE);
        $this->diagnosticInfo = $this->telemetryClient->receive();
    }
}
