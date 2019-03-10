project('Racing-Car-Katas', 'cpp', default_options : ['cpp_std=c++14'])

gtest_dep = dependency('gtest', main : false, required : false)
gmock_dep = dependency('gmock', main : true, required : false)

tirepressure = static_library('TirePressureMonitoring',
        [
        'TirePressureMonitoring/include/Alarm.h',
        'TirePressureMonitoring/include/Sensor.h',
        'TirePressureMonitoring/source/Alarm.cpp',
        'TirePressureMonitoring/source/Sensor.cpp',
        ],
)
tirepressure_api = include_directories('TirePressureMonitoring/include/')
tirepressure_dep = declare_dependency(
        include_directories: [tirepressure_api],
        link_with: [tirepressure],
)

tirepressure_test = executable('tirepressure_test',
       [
       'TirePressureMonitoring/tests/Alarm_Test.cpp',
       ],
       dependencies : [gtest_dep, gmock_dep, tirepressure_dep]
)
test('1)  TirePressureMonitoring Google Test', tirepressure_test)


textconverter = static_library('TextConverter',
        [
	'TextConverter/include/HtmlPagesConverter.h',
	'TextConverter/include/HtmlTextConverter.h',
	'TextConverter/include/StringEscapeUtils.h',
	'TextConverter/source/HtmlPagesConverter.cpp',
	'TextConverter/source/HtmlTextConverter.cpp',
        ],
)
textconverter_api = include_directories('TextConverter/include/')
textconverter_dep = declare_dependency(
        include_directories: [textconverter_api],
        link_with: [textconverter],
)

textconverter_htmltext_test = executable('HtmlTextConverter_Test',
       [
       'TextConverter/tests/HtmlTextConverter_Test.cpp',
       ],
       dependencies : [gtest_dep, gmock_dep, textconverter_dep]
)
test('2a) HtmlTextConverter Google Test', textconverter_htmltext_test)

textconverter_htmlpage_test = executable('HtmlPageConverter_Test',
       [
       'TextConverter/tests/HtmlPageConverter_Test.cpp',
       ],
       dependencies : [gtest_dep, gmock_dep, textconverter_dep]
)
test('2b) HtmlPageConverter Google Test', textconverter_htmlpage_test)

ticketdispenser = static_library('TicketDispenser',
        [
	'TurnTicketDispenser/include/TurnNumberSequence.h',
	'TurnTicketDispenser/include/TurnTicket.h',
	'TurnTicketDispenser/include/TicketDispenser.h',
	'TurnTicketDispenser/source/TurnNumberSequence.cpp',
	'TurnTicketDispenser/source/TurnTicket.cpp',
	'TurnTicketDispenser/source/TicketDispenser.cpp',
        ],
)
ticketdispenser_api = include_directories('TurnTicketDispenser/include/')
ticketdispenser_dep = declare_dependency(
        include_directories: [ticketdispenser_api],
        link_with: [ticketdispenser],
)

ticketdispenser_test = executable('TicketDispenser_Test',
       [
       'TurnTicketDispenser/tests/TicketDispenser_Test.cpp',
       ],
       dependencies : [gtest_dep, gmock_dep, ticketdispenser_dep]
)
test('3)  TicketDispenser Google Test', ticketdispenser_test)

telemetrysystem = static_library('TelemetrySystem',
        [
        'TelemetrySystem/include/TelemetryClient.h',
        'TelemetrySystem/include/TelemetryDiagnosticControls.h',
        'TelemetrySystem/source/TelemetryClient.cpp',
        'TelemetrySystem/source/TelemetryDiagnosticControls.cpp',
        ],
)
telemetrysystem_api = include_directories('TelemetrySystem/include/')
telemetrysystem_dep = declare_dependency(
        include_directories: [telemetrysystem_api],
        link_with: [telemetrysystem],
)

telemetrysystem_test = executable('TelemetrySystem_Test',
       [
       'TelemetrySystem/tests/TelemetryDiagnosticControls_Test.cpp',
       ],
       dependencies : [gtest_dep, gmock_dep, telemetrysystem_dep]
)
test('4)  TelemetrySystem Google Test', telemetrysystem_test)


leaderboard = static_library('LeaderBoard',
        [
	'LeaderBoard/include/Driver.h',
	'LeaderBoard/include/LeaderBoard.h',
	'LeaderBoard/include/SelfDrivingCar.h',
	'LeaderBoard/include/Race.h',
	'LeaderBoard/source/SelfDrivingCar.cpp',
	'LeaderBoard/source/Driver.cpp',
	'LeaderBoard/source/Race.cpp',
	'LeaderBoard/source/LeaderBoard.cpp',
        ],
)
leaderboard_api = include_directories('LeaderBoard/include/')
leaderboard_dep = declare_dependency(
        include_directories: [leaderboard_api],
        link_with: [leaderboard],
)

leaderboard_test = executable('LeaderBoard_Test',
       [
       'LeaderBoard/tests/LeaderBoard_Test.cpp',
       ],
       dependencies : [gtest_dep, gmock_dep, leaderboard_dep]
)
test('5)  LeaderBoard Google Test', leaderboard_test)

