add_library(LeaderBoard
	include/Driver.h
	include/LeaderBoard.h
	include/SelfDrivingCar.h
	include/Race.h
	source/SelfDrivingCar.cpp
	source/Driver.cpp
	source/Race.cpp
	source/LeaderBoard.cpp
)
target_include_directories(LeaderBoard PUBLIC include )
set_property(TARGET LeaderBoard PROPERTY CXX_STANDARD 14)

add_subdirectory(tests)