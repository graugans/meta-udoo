# adapted from linux-imx.inc, copyright (C) 2012-2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-udooboard.inc
require recipes-kernel/linux/linux-dtb.inc

SRCREV = "77702fa515d1276bc0a1e7b62e326937f8451f37"

# This hack is needed because of the
# backports subdir in the kernel source
B = "${S}"

COMPATIBLE_MACHINE = "(udooneo|udooqdl|secosbca62)"
