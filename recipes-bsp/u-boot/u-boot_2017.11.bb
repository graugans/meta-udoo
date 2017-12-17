require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "dtc-native"

# This revision corresponds to the tag "v2016.03"
# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "c253573f3e269fd9a24ee6684d87dd91106018a5"

PV = "2017.11"

UBOOT_SUFFIX = "img"
SPL_BINARY = "SPL"

COMPATIBLE_MACHINE = "udooneo|udooqdl"

SRC_URI_append_udooqdl = " \
        file://0001-udoo-uEnv.txt-bootz-n-fixes.patch \
        file://0002-udoo.h-add-fallback-option-to-load-kernel-dtb-withou.patch \
"

SRC_URI_append_udooneo = " \
        file://0001-ARM-udoo-neo-uEnv.txt-bootz-single-partition-config-v2017.11-rc4.patch \
        file://0002-udoo_neo.h-add-fallback-option-to-load-kernel-dtb-wi.patch \
"
