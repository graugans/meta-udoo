# custom oe-based kernel for upstream plus RCN kernel patch
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${BRANCH_VERSION}:"

include linux-armv7multi.inc

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=http;branch=${KBRANCH};name=machine \
           https://rcn-ee.net/deb/xenial-armhf/${RELEASE_TAG}-${BB_VERSION}/patch-${LINUX_VERSION}-${BB_VERSION}.diff.xz;name=patch \
           file://defconfig \
"

SRC_URI_append_udooqdl = "file://0003-ARM-DTS-imx6qdl-udoo-enable-uart4-serial-interface-f.patch \
                          file://0004-ARM-dts-driver-imx6-udooqdl-add-arduino-manager-driv.patch \
"

PATCHTOOL = "git"

BRANCH_VERSION = "4.14"
LINUX_VERSION = "${BRANCH_VERSION}.6"
RELEASE_TAG = "v${LINUX_VERSION}"
# KERNEL_TAG and RELEASE_TAG are normally in sync but sometimes the patch
# version lags behind the actual kernel tag
KERNEL_TAG = "v${BRANCH_VERSION}.6"
BB_VERSION = "armv7-x2"
LINUX_VERSION_EXTENSION = "-${BB_VERSION}"

SRCREV = "${KERNEL_TAG}"
KBRANCH = "linux-${BRANCH_VERSION}.y"

PV = "${LINUX_VERSION}${LINUX_VERSION_EXTENSION}+git${SRCPV}"

SRC_URI[patch.md5sum] = "361c6ec50ba367acefbf74fa6b36d9cd"
SRC_URI[patch.sha256sum] = "6a49db3314ae5a3bc536af87aef2ce8b77d954bbaeded6232aed89e87ec58e8f"

