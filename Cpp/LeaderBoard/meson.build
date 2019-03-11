leaderboard = static_library('LeaderBoard',
        [
	'include/Driver.h',
	'include/LeaderBoard.h',
	'include/SelfDrivingCar.h',
	'include/Race.h',
	'source/SelfDrivingCar.cpp',
	'source/Driver.cpp',
	'source/Race.cpp',
	'source/LeaderBoard.cpp',
        ],
)
leaderboard_api = include_directories('include/')
leaderboard_dep = declare_dependency(
        include_directories: [leaderboard_api],
        link_with: [leaderboard],
)

leaderboard_test = executable('LeaderBoard_Test',
       [
       'tests/LeaderBoard_Test.cpp',
       ],
       dependencies : [gtest_dep, gmock_dep, leaderboard_dep]
)
test('5)  LeaderBoard Google Test', leaderboard_test)

leaderboard_catch2 = executable('LeaderBoard_catch2',
       [
       'tests/LeaderBoard_catch.cpp',
       ],
       dependencies : [catch2_dep, leaderboard_dep]
)
test('5)  LeaderBoard Catch Test', leaderboard_catch2)


