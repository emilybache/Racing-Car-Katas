cmake_minimum_required(VERSION 2.8.11)
project(tire-pressure C CXX)

set(CMAKE_MODULE_PATH ${CMAKE_CURRENT_SOURCE_DIR}/CMakeModules)

set(CMAKE_BUILD_TYPE Debug)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/bin)

find_package(CppUnit REQUIRED)
include_directories(${CPPUNIT_INCLUDE_DIR})

add_compile_options("--std=c++11")
add_compile_options("-Wall")
add_compile_options("-Werror")

add_subdirectory(src)
add_subdirectory(tst)

