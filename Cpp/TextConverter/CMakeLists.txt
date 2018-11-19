
add_library(TextConverter
	include/HtmlPagesConverter.h
	include/HtmlTextConverter.h
	include/StringEscapeUtils.h
	source/HtmlPagesConverter.cpp
	source/HtmlTextConverter.cpp
)
target_include_directories(TextConverter PUBLIC include )
set_property(TARGET TextConverter PROPERTY CXX_STANDARD 14)
add_subdirectory(tests)