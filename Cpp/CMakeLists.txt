cmake_minimum_required(VERSION 3.5.1)
project(Racing-Car-GMock)
list(APPEND CMAKE_MODULE_PATH "${CMAKE_SOURCE_DIR}/../cmake")
enable_testing()

include(ExternalProject)

message("No system gtest use external project")

configure_file(CMakeLists.txt.in googletest-download/CMakeLists.txt)
execute_process(COMMAND ${CMAKE_COMMAND} -G "${CMAKE_GENERATOR}" .
    RESULT_VARIABLE result
    WORKING_DIRECTORY ${CMAKE_CURRENT_BINARY_DIR}/googletest-download )
if(result)
    message(FATAL_ERROR "CMake step for googletest failed: ${result}")
endif()
execute_process(COMMAND ${CMAKE_COMMAND} --build .
    RESULT_VARIABLE result
    WORKING_DIRECTORY ${CMAKE_CURRENT_BINARY_DIR}/googletest-download )
if(result)
    message(FATAL_ERROR "Build step for googletest failed: ${result}")
endif()

# Prevent overriding the parent project's compiler/linker
# settings on Windows
set(gtest_force_shared_crt ON CACHE BOOL "" FORCE)

# Add googletest directly to our build. This defines
# the gtest and gtest_main targets.
add_subdirectory(${CMAKE_CURRENT_BINARY_DIR}/googletest-src
    ${CMAKE_CURRENT_BINARY_DIR}/googletest-build
    EXCLUDE_FROM_ALL)

set(GTEST_BOTH_LIBRARIES gtest gtest_main)

ExternalProject_Add(aprovaltest
    PREFIX ${CMAKE_BINARY_DIR}/aprovaltest
    URL https://github.com/approvals/ApprovalTests.cpp/releases/download/v.2.0.0/ApprovalTests.v.2.0.0.hpp
    DOWNLOAD_NO_EXTRACT 1
    CONFIGURE_COMMAND ""
    BUILD_COMMAND ""
    INSTALL_COMMAND ""
)

include_directories(${GTEST_INCLUDE_DIRS})
include_directories(${GMOCK_INCLUDE_DIRS})
include_directories(${CMAKE_BINARY_DIR}/aprovaltest/src)

include(CodeCoverage)
APPEND_COVERAGE_COMPILER_FLAGS()

add_subdirectory(TirePressureMonitoring)
add_subdirectory(TextConverter)
add_subdirectory(TurnTicketDispenser)
add_subdirectory(TelemetrySystem)
add_subdirectory(LeaderBoard)


