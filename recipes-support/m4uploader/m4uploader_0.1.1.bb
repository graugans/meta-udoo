DESCRIPTION = "Load an MQX binary to UDOO Neo M4 Core This application works as an uploader that loads \
compiled binaries into UDOO Neo DDR RAM and runs it. Also copy the last binary to /var/opt/m4 for next reboot."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

inherit autotools

SRCREV = "53738b91a7df2c072a17c74239bb4d5fd2d179bd"
SRC_URI = "git://github.com/ektor5/udooneo-m4uploader.git"

PV = "0.1.1+git${SRCPV}"

S = "${WORKDIR}/git"

FILES_${PN} += "/boot"

RDEPENDS_${PN} += "bash"

COMPATIBLE_MACHINE = "(udooneo)"