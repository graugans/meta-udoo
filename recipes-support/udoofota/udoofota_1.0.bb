DESCRIPTION = "UDOO Firmware Over the Air Uploader -- Server \
A little client-server protocol written in C over TCP/IP \
to enable uploading via network for UDOO."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"


inherit update-rc.d

INITSCRIPT_NAME = "udoofota"
INITSCRIPT_PARAMS = "defaults 30"


SRCREV = "bb638a148fa768e462ae058f64521d6a807fc44f"
SRC_URI = "git://github.com/UDOOboard/udoofota.git \
           file://0001-Add-support-for-GCC-overwrite-and-LDFLAGS.patch \
           file://init \
"

PV = "0.1+git${SRCPV}"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${sysconfdir}/init.d
	install -d -m 0755 ${D}${bindir}
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/udoofota
	install -m 0755 ${B}/udooserver ${D}${bindir}
}

RDEPENDS_${PN} += "m4uploader"

COMPATIBLE_MACHINE = "(udooneo)"
