telemetrysystem = static_library('TelemetrySystem',
        [
        'include/TelemetryClient.h',
        'include/TelemetryDiagnosticControls.h',
        'source/TelemetryClient.cpp',
        'source/TelemetryDiagnosticControls.cpp',
        ],
)
telemetrysystem_api = include_directories('include/')
telemetrysystem_dep = declare_dependency(
        include_directories: [telemetrysystem_api],
        link_with: [telemetrysystem],
)

telemetrysystem_test = executable('TelemetrySystem_Test',
       [
       'tests/TelemetryDiagnosticControls_Test.cpp',
       ],
       dependencies : [gtest_dep, gmock_dep, telemetrysystem_dep]
)
test('4)  TelemetrySystem Google Test', telemetrysystem_test)



telemetrysystem_catch2 = executable('TelemetrySystem_catch2',
       [
       'tests/TelemetryDiagnosticControls_catch.cpp',
       ],
       dependencies : [catch2_dep, telemetrysystem_dep]
)
test('4)  TelemetrySystem Catch Test', telemetrysystem_catch2)


