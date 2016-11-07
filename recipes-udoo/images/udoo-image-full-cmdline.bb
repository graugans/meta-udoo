DESCRIPTION = "A console-only image with more full-featured Linux system \
functionality installed. Tailored for the UDOO boards"

IMAGE_FEATURES += "splash ssh-server-openssh package-management"
DEPENDS += "virtual/bootloader"


UDOO_EXTRA_INSTALL = " \
    resize-rootfs \
    screen \
    imx-gpu-viv \
    imx-gpu-viv-demos \
    packagegroup-fsl-tools-gpu \
    binutils \
    minicom \
    i2c-tools \
    dtc \
    mmc-utils \
    ${@base_conditional("ENABLE_CAN_BUS", "1", "canutils", "", d)} \
"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-base \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    ${UDOO_EXTRA_INSTALL} \
    "

inherit core-image

# Needed by resize-rootfs
IMAGE_CMD_ext4_append () {
        # Label the disk rootfs
        e2label ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext4 rootfs
}
