cmake_minimum_required(VERSION 2.8.11)
project(LeaderBoard.Test)

aux_source_directory(source PROJECT_SOURCE)
file(GLOB PROJECT_INCLUDES "include/*.h")

add_executable(${PROJECT_NAME} ${PROJECT_SOURCE} ${PROJECT_INCLUDES})

target_link_libraries(${PROJECT_NAME} LeaderBoard ${CPPUNIT_LIBRARIES})
