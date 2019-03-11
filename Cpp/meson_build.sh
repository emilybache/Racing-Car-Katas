#!/bin/bash
set -x
set -v
BUILD_DIR=build_meson
meson ${BUILD_DIR} -Db_coverage=true
ninja -C ${BUILD_DIR}
ninja -C ${BUILD_DIR} test
ninja -C ${BUILD_DIR} coverage-html

