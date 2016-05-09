require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot for UDOO boards."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM_udooneo = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"
LIC_FILES_CHKSUM_udooqdl = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"
COMPATIBLE_MACHINE = "(udooneo|udooqdl)"

PROVIDES = "u-boot"

SRCBRANCH_udooneo = "2015.04.imx-neo"
SRCBRANCH_udooqdl = "2015.10.fslc-qdl"

PV_udooqdl = "v${SRCBRANCH}+git${SRCPV}"

SRCREV_udooneo = "d7814685bdb364a4162f5bb4431676631591fc38"
SRCREV_udooqdl = "68849f96afa56d5a4cfcdd918bafebc552958d3a"


SRC_URI = "git://github.com/udooboard/uboot-imx.git;branch=${SRCBRANCH} \
           file://0001-remove-dts-subfolder.patch \
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
