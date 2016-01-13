# Adapted from linux-imx.inc, copyright (C) 2012, 2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux kernel for UDOO boards"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

require recipes-kernel/linux/linux-imx.inc

# Put a local version until we have a true SRCREV to point to
SCMVERSION ?= "y"

SRCBRANCH ??= "master"
LOCALVERSION ?= "-${SRCBRANCH}"

# Allow override of UDOOBOARD_GITHUB_MIRROR to make use of
# local repository easier
UDOOBOARD_GITHUB_MIRROR ?= "git://github.com/UDOOboard/linux_kernel.git"

# SRC_URI for udoo boards kernel
SRC_URI = "${UDOOBOARD_GITHUB_MIRROR};branch=${SRCBRANCH} \
           file://0001-ARM-8158-1-LLVMLinux-use-static-inline-in-ARM-ftrace.patch \
           file://0002-ARM-LLVMLinux-Change-extern-inline-to-static-inline-.patch \
           file://0003-avoid-endless-loop.patch \
           file://defconfig \
"

