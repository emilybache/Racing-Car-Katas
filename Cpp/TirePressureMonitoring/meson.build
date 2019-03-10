tirepressure = static_library('TirePressureMonitoring',
        [
        'include/Alarm.h',
        'include/Sensor.h',
        'source/Alarm.cpp',
        'source/Sensor.cpp',
        ],
)
tirepressure_api = include_directories('include/')
tirepressure_dep = declare_dependency(
        include_directories: [tirepressure_api],
        link_with: [tirepressure],
)

tirepressure_test = executable('tirepressure_test',
       [
       'tests/Alarm_Test.cpp',
       ],
       dependencies : [gtest_dep, gmock_dep, tirepressure_dep]
)
test('1)  TirePressureMonitoring Google Test', tirepressure_test)

tirepressure_catch2 = executable('tirepressure_catch2',
       [
       'tests/Alarm_catch.cpp',
       ],
       dependencies : [catch2_dep, tirepressure_dep]
)
test('1)  TirePressureMonitoring Catch2 Test', tirepressure_catch2)


