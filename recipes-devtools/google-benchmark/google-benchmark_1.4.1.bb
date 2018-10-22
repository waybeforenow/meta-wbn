DESCRIPTION = "A microbenchmark support library"
HOMEPAGE = "https://github.com/google/benchmark"
LICENSE = "Apache-2.0 & BSD"
SECTION = "devel"

inherit cmake pkgconfig

# google/benchmark is licensed under Apache-2.0
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
# google/googletest is licensed under BSD 3-Clause
LIC_FILES_CHKSUM += "file://googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a"

SRCREV_benchmark = "e776aa0275e293707b6a0901e0e8d8a8a3679508"
SRCREV_googletest = "2fe3bd994b3189899d93f1d5a881e725e046fdc2"

SRC_URI = "git://github.com/google/benchmark.git;name=benchmark;protocol=https \
	   git://github.com/google/googletest.git;name=googletest;protocol=https;destsuffix=git/googletest \
	   "

S = "${WORKDIR}/git"

OECMAKE_GENERATOR = "Unix Makefiles"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=RELEASE"
EXTRA_OECMAKE += "-DBENCHMARK_ENABLE_GTEST_TESTS=OFF"

do_compile() {
    oe_runmake
}

do_install() {
    oe_runmake install 'DESTDIR=${D}'
}
