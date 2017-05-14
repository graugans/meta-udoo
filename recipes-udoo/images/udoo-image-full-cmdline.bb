DESCRIPTION = "A console-only image with more full-featured Linux system \
functionality installed. Tailored for the UDOO boards"

IMAGE_FEATURES += "splash ssh-server-openssh package-management"

UDOO_EXTRA_INSTALL_arm = " \
    imx-gpu-viv \
    imx-gpu-viv-demos \
    packagegroup-fsl-tools-gpu \
    i2c-tools \
    dtc \
    ${@base_conditional("ENABLE_CAN_BUS", "1", "canutils", "", d)} \
    "
UDOO_EXTRA_INSTALL_x86-64 = " \
    "

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-base \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    ${UDOO_EXTRA_INSTALL} \
    resize-rootfs \
    tmux \
    binutils \
    minicom \
    mmc-utils \
    "

inherit core-image


# Needed by resize-rootfs
IMAGE_DEPENDS_ext4 = "e2fsprogs-native"
IMAGE_CMD_ext4_arm_append () {
        # Label the disk rootfs
        e2label ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext4 rootfs
}
