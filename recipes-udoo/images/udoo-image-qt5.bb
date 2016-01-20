# This requires the meta-qt5 layer in your bblayers.conf !!!!

# source: http://wiki.wandboard.org/index.php/Building_Qt5_using_yocto_on_Wandboard
# If you plan to use Qt5 eglfs plugin for accelerated graphics using the framebuffer,
# you need to discard X11 and wayland so the proper graphics drivers get included.
# To achieve this add the following to your conf/local.conf :
# DISTRO_FEATURES_remove = "x11 wayland"


DESCRIPTION = "A Qt 5.51+ image. Tailored for the UDOO boards"

IMAGE_FEATURES += "splash ssh-server-openssh package-management debug-tweaks"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-base \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    gdbserver \
    gstreamer \
    gst-meta-video \
    gst1.0-fsl-plugin \
    gst-plugins-base-app \
    gst-plugins-base \
    gst-plugins-good \
    gst-plugins-good-rtsp \
    gst-plugins-good-udp \
    gst-plugins-good-rtpmanager \
    gst-plugins-good-rtp \
    gst-plugins-good-video4linux2 \
    openssh-sftp-server \
    packagegroup-fsl-gstreamer1.0-full \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
    imx-vpu \
    imx-test \
    qtbase-fonts \
    qtbase-plugins \
    qtbase-tools \
    qtdeclarative \
    qtdeclarative-plugins \
    qtdeclarative-tools \
    qtdeclarative-qmlplugins \
    qtmultimedia \
    qtmultimedia-plugins \
    qtmultimedia-qmlplugins \
    qtsvg \
    qtsvg-plugins \
    qtsensors \
    qtimageformats-plugins \
    qtsystems \
    qtsystems-tools \
    qtsystems-qmlplugins \
    qtscript \
    qt3d \
    qt3d-qmlplugins \
    qtwebkit \
    qtwebkit-examples-examples \
    qtwebkit-qmlplugins \
    qtgraphicaleffects-qmlplugins \
    qtconnectivity-qmlplugins \
    qtlocation-plugins \
    qtlocation-qmlplugins \
    cinematicexperience \
    cairo pango fontconfig freetype pulseaudio dbus \
    alsa-lib alsa-tools alsa-state fsl-alsa-plugins \
    i2c-tools \
    "

inherit core-image
