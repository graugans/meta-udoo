FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE = "(udooqdl)"

SRC_URI += " \
    file://0001-Switched-to-UDOO-style-uEnv.txt.patch \
    file://uEnv.txt \
"
