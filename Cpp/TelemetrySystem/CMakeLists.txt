add_library(TelemetrySystem
		include/TelemetryClient.h
		include/TelemetryDiagnosticControls.h
		source/TelemetryClient.cpp
		source/TelemetryDiagnosticControls.cpp
)
target_include_directories(TelemetrySystem PUBLIC include )
set_property(TARGET TelemetrySystem PROPERTY CXX_STANDARD 14)

add_subdirectory(tests)