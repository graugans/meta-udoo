SUMMARY = "U-boot boot scripts for Udoo Neo"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
COMPATIBLE_MACHINE = "udooneo"

DEPENDS = "u-boot-mkimage-native"

SRC_URI = "file://boot.cmd"

do_compile() {
    mkimage -A arm -T script -C none -n "Boot script" -d "${WORKDIR}/boot.cmd" boot.scr
}

do_install() {
    install -d ${D}/boot
    install -m 0644 boot.scr ${D}/boot
}
FILES_${PN} += "/boot/*"
