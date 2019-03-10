ticketdispenser = static_library('TicketDispenser',
        [
	'include/TurnNumberSequence.h',
	'include/TurnTicket.h',
	'include/TicketDispenser.h',
	'source/TurnNumberSequence.cpp',
	'source/TurnTicket.cpp',
	'source/TicketDispenser.cpp',
        ],
)
ticketdispenser_api = include_directories('include/')
ticketdispenser_dep = declare_dependency(
        include_directories: [ticketdispenser_api],
        link_with: [ticketdispenser],
)

ticketdispenser_test = executable('TicketDispenser_Test',
       [
       'tests/TicketDispenser_Test.cpp',
       ],
       dependencies : [gtest_dep, gmock_dep, ticketdispenser_dep]
)
test('3)  TicketDispenser Google Test', ticketdispenser_test)

ticketdispenser_catch2 = executable('TicketDispenser_catch2',
       [
       'tests/TicketDispenser_catch.cpp',
       ],
       dependencies : [catch2_dep, ticketdispenser_dep]
)
test('3)  TicketDispenser Catch Test', ticketdispenser_catch2)
