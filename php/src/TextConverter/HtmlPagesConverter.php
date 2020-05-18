<?php
declare(strict_types=1);

namespace RacingCar\TextConverter;

/**
 * Class HtmlPages
 * This is a second, slightly harder problem on the same theme as the UnicodeFileToHtmlTextConverter
 *
 * @package RacingCar\TextConverter
 */
class HtmlPagesConverter
{
    private $filename;
    private $breaks;

    /**
     * HtmlPages constructor.
     * Reads the file and note the positions of the page breaks so we can access them quickly
     * @param string $filename
     */
    public function __construct(string $filename)
    {
        $this->filename = $filename;
        $this->breaks = [0];
        $f = fopen($this->filename, 'r');
        while ($line = fgets($f) !== false)
        {
            $line = rtrim($line);
            if (strpos($line, 'PAGE_BREAK') !== false) {
                $pageBreakPosition = ftell($f);
                $this->breaks[] = ftell($f);
            }
        }
        $this->breaks[] = ftell($f);
        fclose($f);
    }

    /**
     * @param int $page Page number (zero index)
     * @return string HTML page with the given number
     */
    public function getHtmlPage(int $page): string
    {
        $pageStart = $this->breaks[$page];
        $pageEnd = $this->breaks[$page + 1];
        $html = "";
        $f = fopen($this->filename, 'r');
        fseek($f, $pageStart);
        while (ftell($f) != $pageEnd) {
            $line = rtrim(fgets($f));
            if (strpos($line, 'PAGE_BREAK') !== false) {
                continue;
            }
            $html .= htmlspecialchars($line, ENT_QUOTES | ENT_HTML5);
            $html .= "<br />";
        }
        fclose($f);
        return $html;
    }
}
