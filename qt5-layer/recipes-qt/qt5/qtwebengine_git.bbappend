FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"


# Backport of commit d8b2426588abd64c079b8796b7fb3ff68fc2351e from meta-qt5
# This maybe can be removed when fixed upstream

DEPENDS += " qtlocation \
"

SRC_URI += "file://0002-media_capture_devices_dispatcher.h-Include-QCoreApplication-translate.patch \
            file://0003-WebEngine-qquickwebengineview_p_p.h-add-inc-QColor.patch \
            file://0001-chromium-jpeg_codec.cc_Change-false-to-FALSE-and-1-to-TRUE.patch \
"

INSANE_SKIP_${PN} += "textrel"