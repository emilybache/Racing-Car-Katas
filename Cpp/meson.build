project('Racing-Car-Katas', 'cpp', default_options : ['cpp_std=c++14'])

gtest_dep = dependency('gtest', main : false, required : false)
gmock_dep = dependency('gmock', main : true, required : false)
catch2_dep = dependency('catch2', fallback : ['catch2', 'catch2_dep'])

subdir('TirePressureMonitoring')
subdir('TextConverter')
subdir('TurnTicketDispenser')
subdir('TelemetrySystem')
subdir('LeaderBoard')
