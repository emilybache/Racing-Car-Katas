<?php

declare(strict_types=1);

namespace Tests\TextConverter;

use PHPUnit\Framework\TestCase;
use RacingCar\TextConverter\HtmlPagesConverter;

class HtmlPagesConverterTest extends TestCase
{
    public function testFoo()
    {
        $converter = new HtmlPagesConverter("foo");
        $this->assertEquals("fixme", $converter->getFileName());
    }
}
