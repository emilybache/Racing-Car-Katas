<?php

declare(strict_types=1);

namespace Tests\TextConverter;

use PHPUnit\Framework\TestCase;
use RacingCar\TextConverter\HtmlTextConverter;

class HtmlTextConverterTest extends TestCase
{
    public function testFoo()
    {
        $converter = new HtmlTextConverter("foo");
        $this->assertEquals("fixme", $converter->getFileName());
    }
}
