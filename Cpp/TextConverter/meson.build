textconverter = static_library('TextConverter',
        [
	'include/HtmlPagesConverter.h',
	'include/HtmlTextConverter.h',
	'include/StringEscapeUtils.h',
	'source/HtmlPagesConverter.cpp',
	'source/HtmlTextConverter.cpp',
        ],
)
textconverter_api = include_directories('include/')
textconverter_dep = declare_dependency(
        include_directories: [textconverter_api],
        link_with: [textconverter],
)

textconverter_htmltext_test = executable('HtmlTextConverter_Test',
       [
       'tests/HtmlTextConverter_Test.cpp',
       ],
       dependencies : [gtest_dep, gmock_dep, textconverter_dep]
)
test('2a) HtmlTextConverter Google Test', textconverter_htmltext_test)

textconverter_htmlpage_test = executable('HtmlPageConverter_Test',
       [
       'tests/HtmlPageConverter_Test.cpp',
       ],
       dependencies : [gtest_dep, gmock_dep, textconverter_dep]
)
test('2b) HtmlPageConverter Google Test', textconverter_htmlpage_test)

textconverter_catch2 = executable('HtmlTextConverter_catch2',
       [
       'tests/HtmlTextConverter_catch.cpp',
       ],
       dependencies : [catch2_dep, textconverter_dep]
)
test('2)  HtmlTextConverter Catch Test', textconverter_catch2)

