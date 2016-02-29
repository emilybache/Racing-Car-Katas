# src/CMakeLists.txt

include_directories("${CMAKE_SOURCE_DIR}/include")

add_library(
  tirepressure
  sensor.cpp
  alarm.cpp
  )