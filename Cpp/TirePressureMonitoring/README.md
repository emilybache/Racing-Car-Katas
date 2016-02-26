Requirements:
    +CMake
    +CppUnit

Download cmake from: https://cmake.org
Download cppunit from: https://sourceforge.net/projects/cppunit/

General build steps:
(starting in TirePressureMonitoring directory)
mkdir build
cd build
cmake ..
make

Binaries are put in "TirePressureMonitoring/bin"

On windows change "cmake .." to "cmake -G"Visual Studio 12" .."
On mac to generate XCode use "cmake -GXCode .."
google "cmake generators" if you need something else.
