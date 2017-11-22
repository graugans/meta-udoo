SUMMARY = "Add Qt5 bin dir to PATH"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://qt5-env.sh"

S = "${WORKDIR}"

HAS_X11 = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 1, 0, d)}"
HAS_LVDS7 = "${@bb.utils.contains('VIDEO_OUTPUT', 'lvds7', 1, 0, d)}"

do_install() {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0755 qt5-env.sh ${D}${sysconfdir}/profile.d

    if test ${HAS_X11} -eq 0; then
            cat >> ${D}${sysconfdir}/profile.d/qt5-env.sh <<EOF



# QT_QPA_PLATFORM There are multiple platform plugins that are
# potentially usable on Embedded Linux systems: EGLFS, LinuxFB, KMS,
# DirectFB, Wayland. The availability of these depend on the
# configuration of Qt. The default platform plugin is also device
# specific. For instance, on many boards eglfs will be chosen as the
# default one. If the default is not suitable, the QT_QPA_PLATFORM
# environment variable parameter can be used to request another plugin.
# Alternatively, for quick tests, the -platform command-line can be
# used with the same syntax.
export QT_QPA_PLATFORM=eglfs
EOF
    fi

    if test ${HAS_LVDS7} -eq 1; then
            cat >> ${D}${sysconfdir}/profile.d/qt5-env.sh <<EOF


# QT_QPA_EGLFS_PHYSICAL_WIDTH and QT_QPA_EGLFS_PHYSICAL_HEIGHT
# - Physical screen width and height in millimeters. On platforms
# where the framebuffer device /dev/fb0 is not available or the
# query is not successful, the values are calculated based on a
# default DPI of 100. This variable can be used to override any
# such defaults.
export QT_QPA_EGLFS_PHYSICAL_HEIGHT=91
export QT_QPA_EGLFS_PHYSICAL_WIDTH=152
export QT_QPA_EVDEV_TOUCHSCREEN_PARAMETERS=/dev/input/event1:inverty
EOF
    else
            cat >> ${D}${sysconfdir}/profile.d/qt5-env.sh <<EOF


# QT_QPA_EGLFS_PHYSICAL_WIDTH and QT_QPA_EGLFS_PHYSICAL_HEIGHT
# - Physical screen width and height in millimeters. On platforms
# where the framebuffer device /dev/fb0 is not available or the
# query is not successful, the values are calculated based on a
# default DPI of 100. This variable can be used to override any
# such defaults.
#export QT_QPA_EGLFS_PHYSICAL_HEIGHT=91
#export QT_QPA_EGLFS_PHYSICAL_WIDTH=152
#export QT_QPA_EVDEV_TOUCHSCREEN_PARAMETERS=/dev/input/event1:inverty
EOF

    fi

}

FILES_${PN} = "${sysconfdir}"

