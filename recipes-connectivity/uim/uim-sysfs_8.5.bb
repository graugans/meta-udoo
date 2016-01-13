DESCRIPTION = "Shared Transport Line Discipline User Mode initialisation Manager Daemon"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://uim.c;beginline=1;endline=18;md5=9f0bbfbc10c67689e81a523e2976c31e"

INITSCRIPT_NAME = "uim-sysfs"
INITSCRIPT_PARAMS = "defaults 03"

inherit update-rc.d systemd

SRCREV = "cf38cab37f25125afbb9d7b7fd1257e960058350"
SRC_URI = "git://github.com/graugans/uim.git"

S = "${WORKDIR}/git"

do_install() {
    oe_runmake install DESTDIR=${D} PREFIX=${prefix} V=1

        install -d ${D}${sysconfdir}/modprobe.d
        install -m 0644 ${S}/modprobe.d/*.conf ${D}${sysconfdir}/modprobe.d/


    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)};then
        sed -i -e s:/usr/sbin:${sbindir}:g ${S}/systemd/system/ti-uim.service
        install -d ${D}${systemd_unitdir}/system/
        install -m 0644 ${S}/systemd/system/ti-uim.service ${D}${systemd_unitdir}/system
        install -d ${D}/lib/udev/rules.d
        install -m 0644 ${S}/udev/rules.d/*.rules ${D}/lib/udev/rules.d
    else
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 init.d/uim-sysfs ${D}${sysconfdir}/init.d
    fi
}

SYSTEMD_SERVICE_${PN} = "ti-uim.service"

# connman has a plugin to handle all this
RCONFLICTS_${PN} += "connman-plugin-tist"
RRECOMMENDS_${PN} = "linux-firmware-wl18xx"
