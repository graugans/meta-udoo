# Copyright (C) 2012-2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Seco kernel based on the FSL BSP Linux"
DESCRIPTION = "Seco kernel provided support for all Released Secoboards."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

PV = "3.14.28"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SCMVERSION = "n"
SRC_URI = "git://secogit.seco.com/imx6_release/linux-3-14-28-secoboards-imx6_rel.git;protocol=https \
           file://0001-ARM-8158-1-LLVMLinux-use-static-inline-in-ARM-ftrace.patch \
           file://0002-ARM-LLVMLinux-Change-extern-inline-to-static-inline-.patch \
           file://0003-avoid-endless-loop.patch \
           file://defconfig \
"
SRCREV = "${AUTOREV}"

COMPATIBLE_MACHINE = "sbca62q1gb"