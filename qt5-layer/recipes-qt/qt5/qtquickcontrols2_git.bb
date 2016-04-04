require recipes-qt/qt5/qt5.inc
require recipes-qt/qt5/qt5-git.inc

LICENSE = "GFDL-1.3 & BSD & LGPL-3.0"
LIC_FILES_CHKSUM = " \
    file://LICENSE.LGPLv3;md5=8ba7f2099d17d636d5fcc8303bb17587 \
    file://LICENSE.GPLv3;md5=40f9bf30e783ddc201497165dfb32afb \
    file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e \
"

DEPENDS += "qtbase qtxmlpatterns qtdeclarative qtquickcontrols qtgraphicaleffects"

RDEPENDS_${PN}-dev = ""

FILES_${PN} += "${libdir}/qt5/qml/Qt/labs/controls/designer/" 

SRCREV = "fec1a78618bae112ff8d1c0e6f078ea890cf283e"
