<?php

declare(strict_types=1);

namespace RacingCar\TextConverter;

class HtmlPagesConverter
{
    private $filename;

    private $breaks;

    public function __construct(string $filename)
    {
        $this->filename = $filename;

        $this->breaks = [0];
        $f = fopen($this->filename, 'r');
        while (($line = fgets($f)) !== false) {
            $line = rtrim($line);
            if (strpos($line, 'PAGE_BREAK') !== false) {
                $pageBreakPosition = ftell($f);
                $this->breaks[] = ftell($f);
            }
        }
        $this->breaks[] = ftell($f);
        fclose($f);
    }

    public function getHtmlPage(int $page): string
    {
        $f = fopen($this->filename, 'r');
        $pageStart = $this->breaks[$page];
        $pageEnd = $this->breaks[$page + 1];
        fseek($f, $pageStart);
        $html = '';
        while (ftell($f) !== $pageEnd) {
            $line = rtrim(fgets($f));
            if (strpos($line, 'PAGE_BREAK') !== false) {
                break;
            }
            $html .= htmlspecialchars($line, ENT_QUOTES | ENT_HTML5);
            $html .= '<br />';
        }
        fclose($f);
        return $html;
    }

    public function getFileName()
    {
        return $this->filename;
    }
}
