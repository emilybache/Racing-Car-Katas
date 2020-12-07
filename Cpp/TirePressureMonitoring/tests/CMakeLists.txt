
add_executable(TirePressureMonitoring_Test_Gmock
        Alarm_Test.cpp
)

target_link_libraries(TirePressureMonitoring_Test_Gmock
                TirePressureMonitoring
		gtest
		gmock
		gmock_main
		${CMAKE_THREAD_LIBS_INIT}
)
set_property(TARGET TirePressureMonitoring_Test_Gmock PROPERTY CXX_STANDARD 14)
add_dependencies(TirePressureMonitoring_Test_Gmock ApprovalTests)
gtest_discover_tests(TirePressureMonitoring_Test_Gmock)

