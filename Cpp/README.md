C++ Version
===========

CMake Build
-----------

### Needed tools

* CMake: Although not tested on 3.14 it shouldn't (knowingly) use anything
  that not works on this version, the lowest tested version is 3.17.
* C++ compiler supporting C++-14 recognized by CMake > 3.5:ish

### Quick start

```sh
./run-once-cmake.sh
```

### Tested on

 * macOS Big Sur - Cmake 3.17


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
* C++-11 compiler: Tested with clang 7.0, g++ 8.2
* gcovr: for html coverage reports

### Quick start

```sh
./meson_build.sh
```

Coverage report in build\_meson/meson-logs/coveragereport/index.html


### Tested on

 * Ununtu 18.10 - meson 0.49.2
