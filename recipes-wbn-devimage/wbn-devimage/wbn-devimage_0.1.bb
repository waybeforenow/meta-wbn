require recipes-core/images/core-image-base.bb

DESCRIPTION = "A small image just capable of allowing a device to boot and \
is suitable for development work."

IMAGE_FEATURES += " dev-pkgs tools-sdk"
IMAGE_FSTYPES = "tar.gz ext3 rpi-sdimg"

IMAGE_INSTALL += " kernel-modules"
SPLASH = "psplash-raspberrypi"

IMAGE_FEATURES += "ssh-server-openssh splash"

WIFI_SUPPORT = " \
    dhcpcd \
    iw \
    linux-firmware-ralink \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192su \
    init-ifupdown \
    wpa-supplicant \
 "

DEV_EXTRAS = " \
    binutils \
    binutils-symlinks \
    gcc \
    gdb \
    ntp \
    ntp-tickadj \
    make \
    man-db \
    man-pages \
    google-benchmark \
    wbn-dotvim \
 "

EXTRA_TOOLS_INSTALL = " \
    bash \
    bzip2 \
    cronie \
    curl \
    devmem2 \
    dosfstools \
    ethtool \
    findutils \
    git \
    glibc \
    i2c-tools \
    iproute2 \
    less \
    localedef \
    memtester \
    netcat \
    openssh \
    procps \
    rsync \
    sysfsutils \
    tcpdump \
    tmux \
    unzip \
    util-linux \
    wget \
    vim \
    zip \
 "

RPI_UTILS = " \
    bcm2835-tests \
    pi-blaster \
    rpio \
    rpi-gpio \
    userland \
    wiringpi \
 "

ALSA_SUPPORT = " \
    alsa-lib \
    alsa-utils \
    alsa-utils-scripts \
    alsa-tools \
 "

IMAGE_INSTALL += " \
    ${DEV_EXTRAS} \
    ${EXTRA_TOOLS_INSTALL} \
    ${RPI_UTILS} \
    ${WIFI_SUPPORT} \
    ${ALSA_SUPPORT} \
"

do_deploy_append() {
    echo "dtoverlay=fe-pi-audio" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
}
