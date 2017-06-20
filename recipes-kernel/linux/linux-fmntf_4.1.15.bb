# Adapted from linux-imx.inc, copyright (C) 2012, 2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux kernel for UDOO boards"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

# Put a local version until we have a true SRCREV to point to
SCMVERSION ?= "y"

# UDOOboard branch - based on 4.1.15-2.0.x-udoo from Freescale git
SRCBRANCH = "4.1.15_2.x-udoo"
LOCALVERSION = "-2.0.x-udoo"

# Allow override of UDOOBOARD_GITHUB_MIRROR to make use of
# local repository easier
UDOOBOARD_GITHUB_MIRROR ?= "git://github.com/fmntf/linux_kernel.git"

# SRC_URI for udoo boards kernel
SRC_URI = "${UDOOBOARD_GITHUB_MIRROR};branch=${SRCBRANCH} \
           file://0003-fix-build-acc-gyro.patch \
           file://0005-add-support-for-gcc6.patch \
           file://defconfig \
"


SRCREV = "7773e460a540aac9da92f7cc19a457899b0ef5f6"

# This hack is needed because of the
# backports subdir in the kernel source
#B = "${S}"

COMPATIBLE_MACHINE = "(udooneo|udooqdl)"
