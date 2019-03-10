C++ Version
===========

CMake Build
-----------

### Needed tools

* CMake: Althou not tested on 3.5 it shouldn't (knowinly) use anyhting
  thet not works on this version, lowet tested version is 3.10.
* C++ compiler supporting C++-14 reconized by CMake > 3.5:ish
* gcovr - to collect coverage from tests

### Quick start

```sh
./run-once-cmake.sh
```

Coverage report in build/test\_coverage/index.html

### Tested on

 * Ununtu 18.04 - CMake 3.10
 * macOS Mojave - Cmake 3.12


### Random notes

Will download and use googletest (including googlemock)

bash-script for convinience build and test


### Nice things to solve in future

*  Possibly use lcov in place of gcovr if gcovr is missing
*  Possibility for using XCode unit test and coverage

Meson Build
-----------

### Needed tools

* meson: pip install meson
* ninja: Build tool
* C++-11 compiler: Tested with clang 7.0, g++ 8.2
* gcovr: for html coverage reports

### Quick start

```sh
./meson_build.sh
```

Coverage report in build\_meson/meson-logs/coveragereport/index.html


### Tested on

 * Ununtu 18.10 - meson 0.49.2
