C++-14 Version
==============

The test stubs have support for two different test frameworks
catch2 and google test and can optionally link with ApprovalTests
as well. 




CMake Build
-----------

### Needed tools

* CMake: Although not tested on 3.14 it shouldn't (knowingly) use anything
  that not works on this version, the lowest tested version is 3.17.
  Note: CLion have a bundled cmake it works with.
* C++ compiler supporting C++-14 recognized by CMake > 3.5:ish



### Options

There are three options to control what version to build, default all
are on.

- USE_CATCH2: Add Catch2 based tests
- USE_GOOGLE_TEST: Add Google Test based tests
- USE_APPROVAL_TESTS: Add Google Test based tests


### Quick start

Open project in CLion, you can set up build versions with different build flags
in preferences, Build, Execution, Deployment> Cmake add options to CMake Options
souch as: "-DUSE_GOOGLE_TEST=OFF -DUSE_CATCH2=ON -DUSE_APPROVAL_TESTS=ON"

or run from command line: 

```sh
./run-once-cmake.sh
```

### Tested with

 * macOS Big Sur - Cmake 3.17 - CLion 2020.3


### Random notes

Will download and use googletest (including googlemock)
Will download and possible use approval test

bash-script for convenience build and test


### Nice things to solve in future

*  Possibly use lcov in place of gcovr if gcovr is missing
*  Possibility for using XCode unit test and coverage

Meson Build
-----------

### Needed tools

* meson: pip install meson
* ninja: Build tool
* C++-14 compiler: Tested with clang 7.0, g++ 8.2
* gcovr: for html coverage reports

### Quick start

```sh
./meson_build.sh
```

Coverage report in build\_meson/meson-logs/coveragereport/index.html


### Tested with

 * macOS Big Sur - meson 0.50.0
