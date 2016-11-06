DESCRIPTION = "uEnv.txt for UDOO boards"
LICENSE = "GPLv2+"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6 \
"

SRC_URI = "file://uEnv.txt \
"

do_install () {
    install -d ${D}/boot
    install -m 0755 ${WORKDIR}/uEnv.txt ${D}/boot
    if [ -n "${VIDEO_OUTPUT}" ]; then
        sed -i 's/^#\(video_output\)=.*$/\1=${VIDEO_OUTPUT}/g' ${D}/boot/uEnv.txt
        sed -i 's/^\(video_output\)=.*$/\1=${VIDEO_OUTPUT}/g' ${D}/boot/uEnv.txt
    fi
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} = "/boot"
