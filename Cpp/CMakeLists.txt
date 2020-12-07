cmake_minimum_required(VERSION 3.14 FATAL_ERROR)
project(Racing-Car-GMock)
list(APPEND CMAKE_MODULE_PATH "${PROJECT_SOURCE_DIR}/cmake")
set(gtest_force_shared_crt ON CACHE BOOL "" FORCE)

include(FetchContent)

FetchContent_Declare(googletest
        GIT_REPOSITORY https://github.com/google/googletest.git
        GIT_TAG        release-1.10.0
)
FetchContent_MakeAvailable(googletest)

FetchContent_Declare(ApprovalTests
        GIT_REPOSITORY https://github.com/approvals/ApprovalTests.cpp.git
        GIT_TAG master)

FetchContent_MakeAvailable(ApprovalTests)

enable_testing()
include(GoogleTest)

add_subdirectory(TirePressureMonitoring)
add_subdirectory(TextConverter)
add_subdirectory(TurnTicketDispenser)
add_subdirectory(TelemetrySystem)
add_subdirectory(LeaderBoard)


