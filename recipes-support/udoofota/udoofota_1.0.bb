DESCRIPTION = "UDOO Firmware Over the Air Uploader -- Server \
A little client-server protocol written in C over TCP/IP \
to enable uploading via network for UDOO."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"


SRCREV = "bb638a148fa768e462ae058f64521d6a807fc44f"
SRC_URI = "git://github.com/UDOOboard/udoofota.git \
           file://0001-Allow-gcc-overwrite.patch \
"

PV = "0.1+git${SRCPV}"

S = "${WORKDIR}/git"

do_install() {
	install -d -m 0755 ${D}${bindir}
	install -m 0755 ${B}/udooserver ${D}${bindir}
}

COMPATIBLE_MACHINE = "(udooneo)"