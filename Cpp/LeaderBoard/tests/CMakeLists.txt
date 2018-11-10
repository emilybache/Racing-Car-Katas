add_executable(LeaderBoard_Test_Gmock
		LeaderBoard_Test.cpp
	      )

target_link_libraries(LeaderBoard_Test_Gmock
		LeaderBoard
		gtest
		gmock
		gmock_main
		${CMAKE_THREAD_LIBS_INIT}
		)
set_property(TARGET LeaderBoard_Test_Gmock PROPERTY CXX_STANDARD 14)
add_dependencies(LeaderBoard_Test_Gmock aprovaltest)
add_test(NAME LeaderBoard_Test_Gmock COMMAND LeaderBoard_Test_Gmock)


