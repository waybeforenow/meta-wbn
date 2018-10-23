# build and install modular-friend

SUMMARY = "A friend for your synth modules"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=68ed6c9c71a25534b80ecc5fa68570e0"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/waybeforenow/modular-friend;branch=ladder-filter;protocol=https"
PV = "0.1+git${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS = "gcc-runtime alsa-lib"
LDFLAGS = "-lasound -lm -lpthread -lstdc++"

do_compile () {
        oe_runmake
}

do_install () {
        oe_runmake install 'DESTDIR=${D}'
}
