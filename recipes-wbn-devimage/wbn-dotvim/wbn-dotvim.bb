DESCRIPTION="Vim configuration files for wbn dev environment"

LICENSE="MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6abc99b51e0ec58c98abe86dfb826121"

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/waybeforenow/.vim;protocol=https"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "vim perl"

INSANE_SKIP_${PN} += " installed-vs-shipped file-rdeps"
FILES_${PN} = "${ROOT_HOME}/.vim ${ROOT_HOME}/.vim/*"
CONFFILES_${PN} = "${ROOT_HOME}/.vim ${ROOT_HOME}/.vim/*"

do_install() {
    install -d ${D}${ROOT_HOME}/.vim
    cd ${S} && find . -type f -exec install -Dm 755 "{}" ${D}${ROOT_HOME}/.vim/"{}" \;
}
