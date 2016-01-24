DESCRIPTION = "Cortex M4 firmware files for UDOO Neo boards."
LICENSE = "CLOSED"
COMPATIBLE_MACHINE = "(udooneo)"

inherit deploy

SRC_URI = "file://m4clean.fw \
           file://m4startup.fw \
"

do_deploy () {
    install -d ${DEPLOYDIR}
    cp -r ${WORKDIR}/m4* ${DEPLOYDIR}/
}

addtask deploy after do_install

ALLOW_EMPTY_${PN} = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"
