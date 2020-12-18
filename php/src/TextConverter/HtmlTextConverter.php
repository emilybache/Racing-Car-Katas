<?php

declare(strict_types=1);

namespace RacingCar\TextConverter;

class HtmlTextConverter
{
    private $fullFileNameWithPath;

    public function __construct(string $fullFileNameWithPath)
    {
        $this->fullFileNameWithPath = $fullFileNameWithPath;
    }

    public function convertToHtml(): string
    {
        $f = fopen($this->fullFileNameWithPath, 'r');

        $html = '';
        while (($line = fgets($f)) !== false) {
            $line = rtrim($line);
            $html .= htmlspecialchars($line, ENT_QUOTES | ENT_HTML5);
            $html .= '<br />';
        }
        return $html;
    }

    public function getFileName()
    {
        return $this->fullFileNameWithPath;
    }
}
