# build and install naomilauncher

SUMMARY = "Autolauncher for NAOMI roms"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f0ec61570becc1a853c4cca0075f3073"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/waybeforenow/naomilauncher;protocol=https"
PV = "0.1+git${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS = "pcap"
LDFLAGS = "-lpcap"

do_compile () {
        oe_runmake
}

do_install () {
        oe_runmake install 'DESTDIR=${D}'
}

