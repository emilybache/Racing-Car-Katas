cmake_minimum_required(VERSION 2.8.11)
project(Racing-Car-Katas)

set(CMAKE_MODULE_PATH ${CMAKE_CURRENT_SOURCE_DIR}/CMakeModules)

IF(NOT CMAKE_BUILD_TYPE)
  SET(CMAKE_BUILD_TYPE Debug)
ENDIF()

GET_FILENAME_COMPONENT( SOURCE_ROOT . ABSOLUTE )
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${SOURCE_ROOT}/../Bin)
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${SOURCE_ROOT}/../Bin)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${SOURCE_ROOT}/../Bin)

find_package(CppUnit REQUIRED)
include_directories(${CPPUNIT_INCLUDE_DIR})
include_directories(${CMAKE_CURRENT_SOURCE_DIR})

add_compile_options(--std=c++11)
add_compile_options(-Wall)
add_compile_options(-Werror)

add_subdirectory(TirePressureMonitoring)
add_subdirectory(TirePressureMonitoring.Test)
add_subdirectory(LeaderBoard)
add_subdirectory(LeaderBoard.Test)
add_subdirectory(TelemetrySystem)
add_subdirectory(TelemetrySystem.Test)
add_subdirectory(TurnTicketDispenser)
add_subdirectory(TurnTicketDispenser.Test)
add_subdirectory(TextConverter)
add_subdirectory(TextConverter.Test)
