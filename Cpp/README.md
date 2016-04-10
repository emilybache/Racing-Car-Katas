Requirements:
- CMake
- CppUnit

Use your package manager to install or download:
- cmake from: https://cmake.org
- cppunit from: https://sourceforge.net/projects/cppunit/

Binaries are put to "Cpp/Bin" folder.

Build steps to generate makefiles:
1. Go to Cpp directory
2. mkdir build
3. cd build
4. cmake ../Source
5. make

On Windows for VS2012 replace step 3 by:
- cmake -G"Visual Studio 12" ..\Source

On mac for XCode replace step 3 by:
- cmake -G"XCode" ../Source

For Eclipse 4.4 with CDT4 replace step 3 by:
- cmake -G"Eclipse CDT4 - Unix Makefiles" -D_ECLIPSE_VERSION=4.4 ../Source

For CodeBlocks replace step 3 by:
- cmake -G"CodeBlocks - Unix Makefiles" ../Source

For CodeListe replace step 3 by:
- cmake -G"CodeLite - Unix Makefiles" ../Source

google "cmake generators" if you need something else.

