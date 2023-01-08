<?php

declare(strict_types=1);

namespace RacingCar\TextConverter;

class HtmlPagesConverter
{
    /**
     * @var int[]
     */
    private array $breaks;

    public function __construct(
        private string $filename
    ) {
        $this->breaks = [0];
        $f = fopen($this->filename, 'r');
        while (($line = fgets($f)) !== false) {
            $line = rtrim($line);
            if (str_contains($line, 'PAGE_BREAK')) {
                $pageBreakPosition = ftell($f);
                $this->breaks[] = ftell($f);
            }
        }
        $this->breaks[] = ftell($f);
        fclose($f);
    }

    public function getFileName(): string
    {
        return $this->filename;
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
            if (str_contains($line, 'PAGE_BREAK')) {
                break;
            }
            $html .= htmlspecialchars($line, ENT_QUOTES | ENT_HTML5);
            $html .= '<br />';
        }
        fclose($f);
        return $html;
    }
}
