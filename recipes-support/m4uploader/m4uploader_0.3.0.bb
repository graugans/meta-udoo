DESCRIPTION = "Load an MQX binary to UDOO Neo M4 Core This application works as an uploader that loads \
compiled binaries into UDOO Neo DDR RAM and runs it. Also copy the last binary to /var/opt/m4 for next reboot."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

inherit autotools update-rc.d

INITSCRIPT_NAME = "m4uploader"
INITSCRIPT_PARAMS = "defaults 20"

SRCREV = "88e455c8afc9806411682a5f95960a75013d642c"
SRC_URI = "git://github.com/UDOOboard/udooneo-m4uploader.git \
           file://init \
           file://m4last.fw \
"

S = "${WORKDIR}/git"

do_install_append() {
    install -d ${D}/${localstatedir}/opt/m4
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
    install -m 0755 ${WORKDIR}/m4last.fw ${D}/${localstatedir}/opt/m4/m4last.fw
}


RDEPENDS_${PN} += "bash"
COMPATIBLE_MACHINE = "(udooneo)"
