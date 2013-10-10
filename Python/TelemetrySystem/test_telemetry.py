import unittest

from telemetry import *

class TelemetryDiagnosticControlsTest(unittest.TestCase):
    def test_foo(self):
        diagnostics = TelemetryDiagnostics()
        self.assertEqual("foo", diagnostics.diagnostic_info)
        
if __name__ == "__main__":
    unittest.main()