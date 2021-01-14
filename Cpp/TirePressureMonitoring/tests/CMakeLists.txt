
if (USE_GOOGLE_TEST)
    add_executable(TirePressureMonitoring_Test_Gmock
            Alarm_Test.cpp
            )
    set_property(TARGET TirePressureMonitoring_Test_Gmock PROPERTY CXX_STANDARD 14)
    if (NOT USE_APPROVAL_TESTS)
        target_link_libraries(TirePressureMonitoring_Test_Gmock
                TirePressureMonitoring
                gtest
                gmock
                gmock_main
                ${CMAKE_THREAD_LIBS_INIT}
                )
    else()
        target_link_libraries(TirePressureMonitoring_Test_Gmock
                TirePressureMonitoring
                gtest
                gmock
                gmock_main
                ${CMAKE_THREAD_LIBS_INIT}
                ApprovalTests
                )
    endif ()
    gtest_discover_tests(TirePressureMonitoring_Test_Gmock)
endif ()

if (USE_CATCH2)
    add_executable(Alarm_catch
            Alarm_catch.cpp
            )
    set_property(TARGET Alarm_catch PROPERTY CXX_STANDARD 14)
    if (NOT USE_APPROVAL_TESTS)
        target_link_libraries(Alarm_catch
                PRIVATE TirePressureMonitoring
                PRIVATE Catch2::Catch2
                )
    else()
        target_link_libraries(Alarm_catch
                PRIVATE TirePressureMonitoring
                PRIVATE Catch2::Catch2
                ApprovalTests
                )
    endif ()
    include(CTest)
    include(Catch)
    catch_discover_tests(Alarm_catch)
endif ()

