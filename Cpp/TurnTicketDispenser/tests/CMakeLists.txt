
add_executable(TicketDispenser_Test_Gmock
        TicketDispenser_Test.cpp
	      )

target_link_libraries(TicketDispenser_Test_Gmock
		TicketDispenser
		gtest
		gmock
		gmock_main
		${CMAKE_THREAD_LIBS_INIT}
		)
set_property(TARGET TicketDispenser_Test_Gmock PROPERTY CXX_STANDARD 14)
add_dependencies(TicketDispenser_Test_Gmock ApprovalTests)
gtest_discover_tests(TicketDispenser_Test_Gmock)
