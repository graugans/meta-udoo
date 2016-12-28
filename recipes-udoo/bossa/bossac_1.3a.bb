CRIPTION = "BOSSA - The Basic Open Source SAM BA Loader"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d32239bcb673463ab874e80d47fae504"

PR = "r1"
SRC_URI = " \
    https://github.com/UDOOboard/bossac/archive/v${PV}-1.0.zip \
    file://add-gcc-6.x-support.patch \
"
SRC_URI[md5sum] = "51d63b7ea2445e3ec24eca2513dc6ce3"
SRC_URI[sha256sum] = "ff22b376cb1c2978a8082cac46e97f3f729648c020adbb6daf344efc71c0d812"

DEPENDS = "readline"

S = "${WORKDIR}/bossac-${PV}-1.0/udoo/"

do_compile() {
    make -e bin/bossac bin/bossash
}

do_install() {
    install -d ${D}${bindir}
    cp ${S}bin/bossac ${D}${bindir}/bossac-udoo
    cp ${S}bin/bossash ${D}${bindir}/bossash-udoo
}

FILES_${PN} = "${bindir}"
