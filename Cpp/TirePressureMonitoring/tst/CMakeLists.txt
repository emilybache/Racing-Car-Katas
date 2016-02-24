# tst/CMakeLists.txt

include_directories("${CMAKE_SOURCE_DIR}/include")

set(TESTS
  alarm_test.cpp
  sensor_test.cpp
  )

add_executable(
  tests
  main.cpp
  ${TESTS}
  )

target_link_libraries(tests ${CPPUNIT_LIBRARIES})
target_link_libraries(tests tirepressure)