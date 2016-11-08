require recipes-qt/qt5/qt5.inc
require recipes-qt/qt5/qt5-git.inc

LICENSE = "GFDL-1.3 & (LGPL-3.0 | GPL-2.0+)"
LIC_FILES_CHKSUM = " \
    file://LICENSE.LGPLv3;md5=b8c75190712063cde04e1f41b6fdad98\
    file://LICENSE.GPLv2;md5=05832301944453ec79e40ba3c3cfceec\
    file://LICENSE.GPLv3;md5=40f9bf30e783ddc201497165dfb32afb\
    file://LICENSE.FDL;md5=f70ee9a6c44ae8917586fea34dff0ab5\
"

DEPENDS += "qtbase qtserialport"

SRCREV = "04b75569f36eec14662505a08bf8c1d565cb10fe"
