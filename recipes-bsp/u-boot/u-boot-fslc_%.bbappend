FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE = "(udooqdl|udooneo|secosbca62)"

SRC_URI += " \
    file://0001-UDOO-Quad-Dual-support.patch \
    file://0002-Added-UDOO-Neo-support.patch \
    file://0003-Added-Seco-A62-support.patch \
"
