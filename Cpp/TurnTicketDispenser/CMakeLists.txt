add_library(TicketDispenser
	include/TurnNumberSequence.h
	include/TurnTicket.h
	include/TicketDispenser.h
	source/TurnNumberSequence.cpp
	source/TurnTicket.cpp
	source/TicketDispenser.cpp
)
target_include_directories(TicketDispenser PUBLIC include )
set_property(TARGET TicketDispenser PROPERTY CXX_STANDARD 14)

add_subdirectory(tests)