#!/bin/sh

# Export the Qt5 PATH
export PATH=${PATH}:/usr/bin/qt5

# The description of the following environment variables is taken from
# http://doc.qt.io/qt-5/embedded-linux.html
# Those are published under GNU Free Documentation License version 1.3
# as published by the Free Software Foundation.

## EGLFS

# QT_QPA_EGLFS_FB - Overrides the framebuffer device. The default is
# /dev/fb0. On most embedded platforms this is not very relevant
# because the framebuffer is used only for querying settings like the
# display dimensions. On certain devices however this parameter
# provides the ability to specify which display to use in multiple
# display setups, similarly to the fb parameter in LinuxFB.
#
#export QT_QPA_EGLFS_FB=/dev/fb1

# QT_QPA_EGLFS_WIDTH and QT_QPA_EGLFS_HEIGHT - Contain the screen
# width and height in pixels. While eglfs will try to determine the
# dimensions from the framebuffer device /dev/fb0, this will not
# always work and manually specifying the sizes may become necessary.
#
#export QT_QPA_EGLFS_WIDTH=1024
#export QT_QPA_EGLFS_HEIGHT=768


# QT_QPA_EGLFS_DEPTH - Overrides the color depth for the screen. On
# platforms where the framebuffer device /dev/fb0 is not available or
# the query is not successful, the default of 32 is used. This variable
# can be used to override any such defaults. Note that this affects
# only the color depth value reported by QScreen. It has no connection
# to EGL configurations and the color depth used for OpenGL rendering.
#
#

# QT_QPA_EGLFS_SWAPINTERVAL - By default a swap interval of 1 will be
# requested. This enables synchronizing to the displays vertical
# refresh. The value can be overridden with this environment variable.
# For instance, passing 0 will disable blocking on swap, resulting in
# running as fast as possible without any synchronization.
#
#

# QT_QPA_EGLFS_FORCEVSYNC - When set, eglfs requests FBIO_WAITFORVSYNC
# on the framebuffer device.
#
#

# QT_QPA_EGLFS_FORCE888 - When set, the red, green and blue color
# channel sizes are ignored whenever creating a new context, window or
# offscreen surface. Instead, the plugin will request a configuration
# with 8 bits per channel. This can be helpful on devices where
# configurations with less than 32 or 24 bits per pixel are chosen by
# default but are known not to be suitable, for example, due to
# banding effects. Instead of changing all the applications, this
# variable provides an easier shortcut to force 24/32 bpp
# configurations for a given device.
#
#

# QT_QPA_EGLFS_DEBUG - When set, some debugging information is printed
# on the debug output. For example, the input QSurfaceFormat and the
# properties of the chosen EGL configuration are printed whenever
# creating a new context. Together with Qt Quick's QSG_INFO variable,
# this can provide useful information for troubleshooting issues
# related to the EGL configuration.
#
#

# QT_QPA_EGLFS_INTEGRATION - In addition to the compiled-in hooks, it
# is also possible to provide device or vendor-specific adaptation in
# the form of dynamically loaded plugins. This environment variable
# enforces a specific plugin. For example, setting it to eglfs_kms
# will use the KMS/DRM backend. This is only an option when no static,
# compiled-in hooks were specified in the device makespecs. In
# practice the traditional compiled-in hooks are rarely used, almost
# all backends are now migrated to plugins. The device makespecs still
# contain a relevant EGLFS_DEVICE_INTEGRATION entry: the name of the
# preferred backend for that particular device. This is optional, but
# very useful to avoid the need to set this environment variable in
# case there are more than one plugins present in the target system.
# In a desktop environment the KMS or the X11 backends are prioritized,
# depending on the presence of the DISPLAY environment variable. Note
# that on some boards the special value of none will be used instead
# of an actual plugin. This indicates that no special integration is
# necessary to use EGL with the framebuffer and so no plugins should
# be loaded.

