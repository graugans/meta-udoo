DESCRIPTION = "A console-only image with more full-featured Linux system \
functionality installed. Tailored for the UDOO boards"

IMAGE_FEATURES += "splash ssh-server-openssh package-management"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-base \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image
