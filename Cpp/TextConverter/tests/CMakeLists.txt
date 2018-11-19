
add_executable(HtmlTextConverter_Test_Gmock
		HtmlTextConverter_Test.cpp
	      )

target_link_libraries(HtmlTextConverter_Test_Gmock
		TextConverter
		gtest
		gmock
		gmock_main
		${CMAKE_THREAD_LIBS_INIT}
		)
set_property(TARGET HtmlTextConverter_Test_Gmock PROPERTY CXX_STANDARD 14)
add_dependencies(HtmlTextConverter_Test_Gmock aprovaltest)
add_test(NAME HtmlTextConverter_Test_Gmock COMMAND HtmlTextConverter_Test_Gmock)

add_executable(HtmlPageConverter_Test_Gmock
		HtmlPageConverter_Test.cpp
	      )

target_link_libraries(HtmlPageConverter_Test_Gmock
		TextConverter
		gtest
		gmock
		gmock_main
		${CMAKE_THREAD_LIBS_INIT}
		)
set_property(TARGET HtmlPageConverter_Test_Gmock PROPERTY CXX_STANDARD 14)
add_dependencies(HtmlPageConverter_Test_Gmock aprovaltest)
add_test(NAME HtmlPageConverter_Test_Gmock COMMAND HtmlPageConverter_Test_Gmock)
