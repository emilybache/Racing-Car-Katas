cmake_minimum_required(VERSION 3.14 FATAL_ERROR)
project(Racing-Car-GMock)
list(APPEND CMAKE_MODULE_PATH "${PROJECT_SOURCE_DIR}/cmake")

option(USE_CATCH2 "Add Catch2 based tests" ON)
option(USE_GOOGLE_TEST "Add Google Test based tests" ON)
option(USE_APPROVAL_TESTS "Add Google Test based tests" ON)

message(STATUS "Use USE_CATCH2: ${USE_CATCH2}")
message(STATUS "Use USE_GOOGLE_TEST: ${USE_GOOGLE_TEST}")
message(STATUS "Use USE_APPROVAL_TESTS: ${USE_APPROVAL_TESTS}")
if (NOT USE_APPROVAL_TESTS)
    message(STATUS "No Approval tests")
endif ()
include(FetchContent)

if (USE_CATCH2)
    FetchContent_Declare(Catch2
            GIT_REPOSITORY https://github.com/catchorg/Catch2.git
            GIT_TAG v2.13.1)
    FetchContent_MakeAvailable(Catch2)
    list(APPEND CMAKE_MODULE_PATH "${Catch2_SOURCE_DIR}/contrib")

endif ()
if (USE_GOOGLE_TEST)
    FetchContent_Declare(googletest
            GIT_REPOSITORY https://github.com/google/googletest.git
            GIT_TAG release-1.10.0
            )
    FetchContent_MakeAvailable(googletest)
endif ()
if (USE_APPROVAL_TESTS)
    FetchContent_Declare(ApprovalTests
            GIT_REPOSITORY https://github.com/approvals/ApprovalTests.cpp.git
            GIT_TAG master)
    FetchContent_MakeAvailable(ApprovalTests)
endif ()


enable_testing()
include(GoogleTest)

add_subdirectory(TirePressureMonitoring)
add_subdirectory(TextConverter)
add_subdirectory(TurnTicketDispenser)
add_subdirectory(TelemetrySystem)
add_subdirectory(LeaderBoard)


