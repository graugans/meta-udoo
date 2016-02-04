LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
DEPENDS = "u-boot-mkimage-native"
DESCRIPTION = "Install an u-boot script in the final .sdcard image"

COMPATIBLE_MACHINE = "sbca62q1gb"

SRC_URI = "file://bootscript.source \
           file://COPYING "

S = "${WORKDIR}"

inherit deploy

do_mkimage () {
    uboot-mkimage  -A arm -O linux -T script -C none -a 0 -e 0 \
                   -n "boot script" -d bootscript.source \
                   bootscript
}

addtask mkimage after do_compile before do_install

do_deploy () {
    install -d ${DEPLOYDIR}
    rm -f ${DEPLOYDIR}/bootscript
    install ${S}/bootscript ${DEPLOYDIR}/bootscript
}

addtask deploy after do_install before do_build

do_compile[noexec] = "1"
do_install[noexec] = "1"
do_populate_sysroot[noexec] = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

