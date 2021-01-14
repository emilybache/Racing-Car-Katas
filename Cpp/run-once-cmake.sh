#!/bin/bash

if [[ ! -d cmake-build-script ]]; then
    mkdir -p cmake-build-script
fi

cd cmake-build-script
cmake .. -DCMAKE_BUILD_TYPE=DEBUG && cmake --build . && cmake --build . --target test