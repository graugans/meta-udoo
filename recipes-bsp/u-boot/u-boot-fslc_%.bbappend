FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE = "(udooqdl|udooneo|secosbca62)"

RDEPENDS_${PN}_append_udooneo = " udoo-u-boot-scr"

SRC_URI += " \
    file://0001-UDOO-Quad-Dual-support.patch \
    file://0002-Added-UDOO-Neo-support.patch \
    file://0003-Added-Seco-A62-support.patch \
    file://0004-Added-device-tree-overlay-support.patch \
    file://0005-u-boot-neo-Add-CMD_PXE-to-udoo_neo_defconfig.patch \
    file://0006-u-boot-fslc-Set-default-environment-variables-for-PX.patch \
"
