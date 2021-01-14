if (USE_GOOGLE_TEST)
    add_executable(HtmlTextConverter_Test_Gmock
            HtmlTextConverter_Test.cpp
            )
    set_property(TARGET HtmlTextConverter_Test_Gmock PROPERTY CXX_STANDARD 14)
    if (NOT USE_APPROVAL_TESTS)
        target_link_libraries(HtmlTextConverter_Test_Gmock
                PRIVATE TextConverter
                PRIVATE gtest
                PRIVATE gmock
                PRIVATE gmock_main
                ${CMAKE_THREAD_LIBS_INIT}
                )
    else ()
        target_link_libraries(HtmlTextConverter_Test_Gmock
                PRIVATE TextConverter
                PRIVATE gtest
                PRIVATE gmock
                PRIVATE gmock_main
                ${CMAKE_THREAD_LIBS_INIT}
                ApprovalTests
                )
    endif ()
    gtest_discover_tests(HtmlTextConverter_Test_Gmock)

    add_executable(HtmlPageConverter_Test_Gmock
            HtmlPageConverter_Test.cpp
            )
    if (NOT USE_APPROVAL_TESTS)
        target_link_libraries(HtmlPageConverter_Test_Gmock
                PRIVATE TextConverter
                PRIVATE gtest
                PRIVATE gmock
                PRIVATE gmock_main
                ${CMAKE_THREAD_LIBS_INIT}
                )
    else ()
        target_link_libraries(HtmlPageConverter_Test_Gmock
                PRIVATE TextConverter
                PRIVATE gtest
                PRIVATE gmock
                PRIVATE gmock_main
                ${CMAKE_THREAD_LIBS_INIT}
                ApprovalTests
                )
    endif ()
    set_property(TARGET HtmlPageConverter_Test_Gmock PROPERTY CXX_STANDARD 14)
    gtest_discover_tests(HtmlPageConverter_Test_Gmock)
endif ()

if (USE_CATCH2)
    add_executable(HtmlTextConverter_Test_Catch
            HtmlTextConverter_catch.cpp
            )
    set_property(TARGET HtmlTextConverter_Test_Catch PROPERTY CXX_STANDARD 14)
    if (NOT USE_APPROVAL_TESTS)
        target_link_libraries(HtmlTextConverter_Test_Catch
                PRIVATE TextConverter
                PRIVATE Catch2::Catch2
                )
    else ()
        target_link_libraries(HtmlTextConverter_Test_Catch
                PRIVATE TextConverter
                PRIVATE Catch2::Catch2
                ApprovalTests
                )
    endif ()

    include(CTest)
    include(Catch)
    catch_discover_tests(HtmlTextConverter_Test_Catch)

    add_executable(HtmlPageConverter_catch
            HtmlPageConverter_catch.cpp
            )
    set_property(TARGET HtmlPageConverter_catch PROPERTY CXX_STANDARD 14)
    if (NOT USE_APPROVAL_TESTS)
        target_link_libraries(HtmlPageConverter_catch
                PRIVATE TextConverter
                PRIVATE Catch2::Catch2
                )
    else ()
        target_link_libraries(HtmlPageConverter_catch
                PRIVATE TextConverter
                PRIVATE Catch2::Catch2
                ApprovalTests
                )
    endif ()

    catch_discover_tests(HtmlPageConverter_catch)

endif ()
