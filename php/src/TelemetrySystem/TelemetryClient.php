<?php
declare(strict_types=1);

namespace RacingCar\TelemetrySystem;

use Exception;
use InvalidArgumentException;

class TelemetryClient
{
    public const DIAGNOSTIC_MESSAGE = "AT#UD";
    private $onlineStatus = false;
    private $diagnosticMessageJustSent = false;

    /**
     * @param string $telemetryServerConnectionString
     * @throws Exception
     */
    public function connect(string $telemetryServerConnectionString): void
    {
        if (empty($telemetryServerConnectionString))
            throw new InvalidArgumentException();

        // Fake the connection with 80% changes of failure
        $success = random_int(1, 10) <= 2;

        $this->onlineStatus = $success;
    }

    public function disconnect(): void
    {
        $this->onlineStatus = false;
    }

    /**
     * @param string $message
     * @throws Exception
     */
    public function send(string $message): void
    {
        if (empty($message))
            throw new InvalidArgumentException();

        // The simulation of send() actually just remember
        // if the last message sent was a diagnostic
        // message.
        // This information will be used to simulate the
        // receive(). Indeed there is no real server
        // listening.
        if ($message === self::DIAGNOSTIC_MESSAGE)
            $this->diagnosticMessageJustSent = true;
        else
            $this->diagnosticMessageJustSent = false;
    }

    /**
     * @return string
     * @throws Exception
     */
    public function receive(): string
    {
        if ($this->diagnosticMessageJustSent) {
            # Simulate the reception of the diagnostic message
            $message =
"LAST TX rate................ 100 MBPS\r\n
HIGHEST TX rate............. 100 MBPS\r\n
LAST RX rate................ 100 MBPS\r\n
HIGHEST RX rate............. 100 MBPS\r\n
BIT RATE.................... 100000000\r\n
WORD LEN.................... 16\r\n
WORD/FRAME.................. 511\r\n
BITS/FRAME.................. 8192\r\n
MODULATION TYPE............. PCM/FM\r\n
TX Digital Los.............. 0.75\r\n
RX Digital Los.............. 0.10\r\n
BEP Test.................... -5\r\n
Local Rtrn Count............ 00\r\n
Remote Rtrn Count........... 00";
            $this->diagnosticMessageJustSent = false;
        } else {
            #  Simulate the reception of a response message returning a random message.
            $message = "";
            $messageLength = random_int(0, 50) + 60;
            $i = $messageLength;
            for ($i = $messageLength; $i >= 0; $i--) {
                $message .= chr(random_int(0, 40) + 86);
            }
        }

        return $message;
    }

    public function getOnlineStatus()
    {
        return $this->onlineStatus;
    }
}
