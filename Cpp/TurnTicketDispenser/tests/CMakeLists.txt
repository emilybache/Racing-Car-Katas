if (USE_GOOGLE_TEST)
    add_executable(TicketDispenser_Test_Gmock
            TicketDispenser_Test.cpp
            )
    set_property(TARGET TicketDispenser_Test_Gmock PROPERTY CXX_STANDARD 14)
    if (NOT USE_APPROVAL_TESTS)
        target_link_libraries(TicketDispenser_Test_Gmock
                TicketDispenser
                gtest
                gmock
                gmock_main
                ${CMAKE_THREAD_LIBS_INIT}
                )
    else ()
        target_link_libraries(TicketDispenser_Test_Gmock
                TicketDispenser
                gtest
                gmock
                gmock_main
                ${CMAKE_THREAD_LIBS_INIT}
                ApprovalTests
                )
    endif ()
    gtest_discover_tests(TicketDispenser_Test_Gmock)
endif ()

if (USE_CATCH2)
    add_executable(TicketDispenser_catch
            TicketDispenser_catch.cpp
            )
    set_property(TARGET TicketDispenser_catch PROPERTY CXX_STANDARD 14)
    if (NOT USE_APPROVAL_TESTS)
        target_link_libraries(TicketDispenser_catch
                PRIVATE TicketDispenser
                PRIVATE Catch2::Catch2
                )
    else()
        target_link_libraries(TicketDispenser_catch
                PRIVATE TicketDispenser
                PRIVATE Catch2::Catch2
                ApprovalTests
                )
    endif ()
    include(CTest)
    include(Catch)
    catch_discover_tests(TicketDispenser_catch)
endif ()

