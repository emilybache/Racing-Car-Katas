
if (USE_GOOGLE_TEST)
    add_executable(TelemetryDiagnosticControls_Gmock
            TelemetryDiagnosticControls_Test.cpp
            )

    set_property(TARGET TelemetryDiagnosticControls_Gmock PROPERTY CXX_STANDARD 14)
    if (NOT USE_APPROVAL_TESTS)
        target_link_libraries(TelemetryDiagnosticControls_Gmock
                PRIVATE TelemetrySystem
                PRIVATE gtest
                PRIVATE gmock
                PRIVATE gmock_main
                ${CMAKE_THREAD_LIBS_INIT}
                )
    else()
        target_link_libraries(TelemetryDiagnosticControls_Gmock
                PRIVATE TelemetrySystem
                PRIVATE gtest
                PRIVATE gmock
                PRIVATE gmock_main
                ${CMAKE_THREAD_LIBS_INIT}
                ApprovalTests
                )
    endif ()
    gtest_discover_tests(TelemetryDiagnosticControls_Gmock)
endif ()

if (USE_CATCH2)
    add_executable(TelemetryDiagnosticControls_Test_Catch
            TelemetryDiagnosticControls_catch.cpp
            )

    set_property(TARGET TelemetryDiagnosticControls_Test_Catch PROPERTY CXX_STANDARD 14)
    if (NOT USE_APPROVAL_TESTS)
        target_link_libraries(TelemetryDiagnosticControls_Test_Catch
                PRIVATE TelemetrySystem
                PRIVATE Catch2::Catch2
                )
    else()
        target_link_libraries(TelemetryDiagnosticControls_Test_Catch
                PRIVATE TelemetrySystem
                PRIVATE Catch2::Catch2
                ApprovalTests
                )
    endif ()
    include(CTest)
    include(Catch)
    catch_discover_tests(TelemetryDiagnosticControls_Test_Catch)
endif ()
