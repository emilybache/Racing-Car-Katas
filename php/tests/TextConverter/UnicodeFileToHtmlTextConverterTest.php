<?php

use PHPUnit\Framework\TestCase;
use RacingCar\TextConverter\UnicodeFileToHtmlTextConverter;

class UnicodeFileToHtmlTextConverterTest extends TestCase
{
    public function testFoo()
    {
        $converter = new UnicodeFileToHtmlTextConverter("foo");
        $this->assertEquals("fixme", $converter->getFileName());
    }
}