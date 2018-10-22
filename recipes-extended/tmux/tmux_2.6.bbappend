SRC_URI_append := " file://tmux.conf"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILES_${PN}_append := " ${ROOT_HOME}/.tmux.conf"

do_install_append() {
	install -d ${D}${ROOT_HOME}
	install -m 644 ${WORKDIR}/tmux.conf ${D}${ROOT_HOME}/.tmux.conf
}

