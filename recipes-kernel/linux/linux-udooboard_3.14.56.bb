# adapted from linux-imx.inc, copyright (C) 2012-2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-udooboard.inc
require recipes-kernel/linux/linux-dtb.inc

SRCREV = "feef1c3cf4a36f50d94e4b0ec4615cad4a32dfde"

# This hack is needed because of the
# backports subdir in the kernel source
B = "${S}"

COMPATIBLE_MACHINE = "(udooneo|udooqdl)"
