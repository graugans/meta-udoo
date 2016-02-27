require recipes-bsp/u-boot/u-boot.inc

PV = "2016.01"

COMPATIBLE_MACHINE = "secosbca62"

# Copyright (C) 2015 Seco srl
DESCRIPTION = "U-Boot provided by graugans for A62 boards."
PROVIDES = "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

SRCBRANCH ?= "seco-a62-v2016.01"

SRC_URI = "git://github.com/graugans/u-boot-seco.git;branch=${SRCBRANCH} \
"
SRCREV = "9f1d77ac08beba2afebbf46748971fba37f44453"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

LOCALVERSION ?= "-${SRCBRANCH}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

