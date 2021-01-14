
if (USE_GOOGLE_TEST)
	add_executable(LeaderBoard_Test_Gmock
			LeaderBoard_Test.cpp
			)
	set_property(TARGET LeaderBoard_Test_Gmock PROPERTY CXX_STANDARD 14)
	if (NOT USE_APPROVAL_TESTS)
		target_link_libraries(LeaderBoard_Test_Gmock
				PRIVATE LeaderBoard
				PRIVATE gtest
				PRIVATE gmock
				PRIVATE gmock_main
				${CMAKE_THREAD_LIBS_INIT}
				)
	else()
		target_link_libraries(LeaderBoard_Test_Gmock
				PRIVATE LeaderBoard
				PRIVATE gtest
				PRIVATE gmock
				PRIVATE gmock_main
				${CMAKE_THREAD_LIBS_INIT}
				ApprovalTests
				)
	endif ()
	gtest_discover_tests(LeaderBoard_Test_Gmock)
endif ()

if (USE_CATCH2)
	add_executable(LeaderBoard_Test_Catch2
			LeaderBoard_catch.cpp
			)
	set_property(TARGET LeaderBoard_Test_Catch2 PROPERTY CXX_STANDARD 14)
	if (NOT USE_APPROVAL_TESTS)
		target_link_libraries(LeaderBoard_Test_Catch2
				PRIVATE LeaderBoard
				PRIVATE Catch2::Catch2
				)
	else()
		target_link_libraries(LeaderBoard_Test_Catch2
				PRIVATE LeaderBoard
				PRIVATE Catch2::Catch2
				ApprovalTests
				)
	endif ()
	include(CTest)
	include(Catch)
	catch_discover_tests(LeaderBoard_Test_Catch2)
endif ()

