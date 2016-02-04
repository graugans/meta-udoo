require recipes-bsp/u-boot/u-boot.inc

# This revision corresponds to the tag "v2014.04"
# We use the revision in order to avoid having to fetch it from the repo during parse

PV = "2014.04"

COMPATIBLE_MACHINE = "sbca62q1gb"

# Copyright (C) 2015 Seco srl
DESCRIPTION = "U-Boot provided by SECO for secoboards."
PROVIDES = "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"

SCMVERSION = "n"
SRC_URI = "git://secogit.seco.com/imx6_release/u-boot-2014-04-secoboards-imx6_rel.git;protocol=https \
           file://0001-bootscriptload-6aa8d4a4f6374b0709ba331ae5b902319871b65b.patch \
           file://0001-Add-linux-compiler-gcc5.h-to-fix-builds-with-gcc5.patch \
           file://0002-ARM-asm-io.h-use-static-inline.patch \
           file://0003-use-the-gcc-inline-version.patch \
"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

LOCALVERSION ?= "-${SRCBRANCH}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

