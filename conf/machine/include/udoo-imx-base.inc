# Vivante stuff
MACHINE_USES_VIVANTE_KERNEL_DRIVER_MODULE ?= "1"

# Das u-boot settings
UBOOT_MAKE_TARGET = ""
UBOOT_SUFFIX = "img"
UBOOT_CONFIG ??= "sd"
SPL_BINARY = "SPL"

# We use WIC for image creation
IMAGE_DEPENDS_wic_append = " virtual/bootloader"
WKS_FILE = "udoo-sdcard.wks" 
IMAGE_FSTYPES = "wic.bz2"

# There is no more boot partition so install the needed files to /boot
MACHINE_ESSENTIAL_EXTRA_RDEPENDS += " uenv kernel-devicetree \
"
