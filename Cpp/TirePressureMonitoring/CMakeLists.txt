
add_library(TirePressureMonitoring
   include/Alarm.h
   include/Sensor.h
   source/Alarm.cpp
   source/Sensor.cpp
)
target_include_directories(TirePressureMonitoring PUBLIC include )
set_property(TARGET TirePressureMonitoring PROPERTY CXX_STANDARD 14)

add_subdirectory(tests)