DESCRIPTION = "Firmware files for TI Bluetooth Chips"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f39eac9f4573be5b012e8313831e72a9 \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# This recipe provides the latest firmware files for wl18xx.
# Therefore, use the contents of this recipe instead of the contents
PR = "r0+gitr${SRCREV}"
COMPATIBLE_MACHINE = "udooneo"

SRCREV = "781e59b1b1bec213f82ce7c94e55d30914cf5601"
SRC_URI = "git://git.ti.com/ti-bt/service-packs.git \
           file://0001-Makefile-allow-building-within-the-OE.patch \
"

S = "${WORKDIR}/git"
do_compile() {
    :
}

do_configure() {
    :
}


do_install() {
    install -d ${D}${base_libdir}/firmware
    oe_runmake 'DEST_DIR=${D}' 'BASE_LIB_DIR=${base_libdir}' install
}

FILES_${PN} += "${base_libdir}/firmware"
