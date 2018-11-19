add_executable(TelemetryDiagnosticControls_Test_Gmock
        TelemetryDiagnosticControls_Test.cpp
	      )

target_link_libraries(TelemetryDiagnosticControls_Test_Gmock
		TelemetrySystem
		gtest
		gmock
		gmock_main
		${CMAKE_THREAD_LIBS_INIT}
		)
set_property(TARGET TelemetryDiagnosticControls_Test_Gmock PROPERTY CXX_STANDARD 14)
add_dependencies(TelemetryDiagnosticControls_Test_Gmock aprovaltest)
add_test(NAME TelemetryDiagnosticControls_Test_Gmock COMMAND TelemetryDiagnosticControls_Test_Gmock)

