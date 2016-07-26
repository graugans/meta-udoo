require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot for UDOO boards."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"
COMPATIBLE_MACHINE = "(udooneo|udooqdl)"

PROVIDES = "u-boot"

SRCBRANCH = "2015.04.imx"

PV = "v${SRCBRANCH}+git${SRCPV}"

SRCREV = "7271b51aeb519414c0de20de077916dac33085e2"


SRC_URI = "git://github.com/udooboard/uboot-imx.git;branch=${SRCBRANCH} \
           file://0001-Removed-dts-folder-from-device-tree-file-name.patch \
           file://uEnv.txt \
"

S = "${WORKDIR}/git"

do_install_append_udooneo() {

    if [ -n "${VIDEO_OUTPUT}" ]; then
        sed -i 's/^#\(video_output\)=.*$/\1=${VIDEO_OUTPUT}/g' ${D}/boot/${UBOOT_ENV_IMAGE}
        sed -i 's/^\(video_output\)=.*$/\1=${VIDEO_OUTPUT}/g' ${D}/boot/${UBOOT_ENV_IMAGE}
    fi
}

do_deploy_append_udooneo() {
    if [ -n "${VIDEO_OUTPUT}" ]; then
        sed -i 's/^#\(video_output\)=.*$/\1=${VIDEO_OUTPUT}/g' ${DEPLOYDIR}/${UBOOT_ENV_IMAGE}
        sed -i 's/^\(video_output\)=.*$/\1=${VIDEO_OUTPUT}/g' ${DEPLOYDIR}/${UBOOT_ENV_IMAGE}
    fi
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
