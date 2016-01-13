# adapted from linux-imx.inc, copyright (C) 2012-2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-udooboard.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

# UDOOboard branch - based on 3.14.28_1.0.0_ga from Freescale git

SRCBRANCH = "3.14-1.0.x-udoo"
SRCREV = "757d7c70db5b8cc6839b1d38ab799f6ad91e83ba"
LOCALVERSION = "_1.0.0_ga-udooboard"

B = "${S}"

COMPATIBLE_MACHINE = "(udooneo|udooqdl)"
