OpenEmbedded/Yocto BSP layer for the UDOO i.mx6 based boards
===========================================================

This layer provides support for UDOO i.mx6 family based platforms for
use with OpenEmbedded and/or Yocto Freescale's BSP layers.

This layer depends on:

URI: git://git.openembedded.org/openembedded-core
branch: pyro
revision: HEAD

URI: https://github.com/Freescale/meta-freescale.git
branch: pyro
revision: HEAD

Images
======

- udoo-image-full-cmdline
  A command line image with SSH server support and most of the packages in this layer
- udoo-image-qt5
  Providing a qt5 enabled image with a lot of Qt5 goodies. This image requires the meta-qt5 layer

Optional build configuration
============================

Enable SPI bus on the UDOO Neo
==============================
By default the ECSPI_2 bus is disabled in the device tree to enable the SPI bus a device tree modification is needed.
To activate this patch set this variable to enable SPI bus
```
ENABLE_SPI_BUS = "1"
```

Enable CAN bus on the UDOO Neo
===============================
By default both  CAN bus interfaces are disabled in the device tree to enable the CAN bus a device tree modification is needed. To activate this patch set this variable to enable CAN bus
```
ENABLE_CAN_BUS = "1"
```

Select the video outputmode on the UDOO Neo
===========================================
By default the UDOO Neo activates HDMI output. To enable the ``lvds7`` or ``lvds15`` this variable has to be set
```
VIDEO_OUTPUT = "lvds7"
```

Valid options are:
- hdmi
   The default value which activates HDMI only output
- lvds7
   Support for the official LVDS7 display Kit
- lvds15
   Support for the official LVDS15 display Kit

Creating a SD-Card image
========================

The recommended way to create a SD-Card image is the usage of the ``wic`` tool

```
wic create udoo-sdcard -e udoo-image-full-cmdline -o /var/tmp/wic/udooneo
```

The output will look like this:

```
Checking basic build environment...
Done.

Creating image(s)...

Info: The new image(s) can be found here:
  /var/tmp/wic/udooneo/build/udoo-sdcard-201611022045-mmcblk.direct

The following build artifacts were used to create the image(s):
  ROOTFS_DIR:                   /home/chris/src/udoo-community-bsp/build/tmp/work/udooneo-poky-linux-gnueabi/udoo-image-full-cmdline/1.0-r0/rootfs
  BOOTIMG_DIR:
  KERNEL_DIR:                   /home/chris/src/udoo-community-bsp/build/tmp/deploy/images/udooneo
  NATIVE_SYSROOT:               /home/chris/src/udoo-community-bsp/build/tmp/sysroots/x86_64-linux


The image(s) were created using OE kickstart file:
  /home/chris/src/udoo-community-bsp/sources/meta-udoo/scripts/lib/wic/canned-wks/udoo-sdcard.wks
```


Configure NFS Boot
==================

The UDOO boards can be configured to load the kernel, DTB and
rootfilesystem over the network.  This allows for faster iterations
since there is no delay for writing new images to SDCards.  There are
many ways to accomplish this and the actual setup will depend heavily
on your networking infrastructure.

One mechanism to support this is if your server supports NFS, tftp and
PXE.  I use a Synology DS916+ and it supports this setup.  First, make
sure that TFTP, NFS and PXE are enabled and that the MAC address and
IP address of your target board are configured to allow access to these
services.  See your server OS documentation for specifics.

You will need to ensure that you are building the ```.tar.bz2``` image
as part of your build.  Add the following to your local.conf, noting
specifically the space after the first quote character:

```
IMAGE_FSTYPES += " .tar.bz2"
```

After your ```bitbake``` build completes, you need to copy the DTB file,
kernel image and root filesystem tar archive to your server. You will need
to select the actual filenames from your build directory based on your configuration.

On your build system:

```
$ scp ~/build/tmp/deploy/images/udooneo/udoo-image-full-cmdline-udooneo.tar.bz2 nas:/tftpboot/
$ scp ~/build/tmp/deploy/images/udooneo/zImage-imx6sx-udoo-neo-full.dtb nas:/tftpboot/
$ scp ~/build/tmp/deploy/images/udooneo/zImage-udooneo.bin nas:/tftpboot/
```

Next you will need to extract the root filesystem tar archive into a location that
is exported via NFS.

On your server:

```
# tar -C /tftpboot/rootfs -xf /tftpboot/udoo-image-full-cmdline-udooneo.tar.bz2
```

Then you will need to create a PXE configuration file. This file needs to be available
over TFTP and is named based on the MAC address of your board.  For instance, if your
boards MAC address is 00:11:22:33:44:55:66 then you will create a file on your server
named ```/tftpboot/00-11-22-33-44-55-66``` with the following contents:

```
default menu.c32
prompt 0
timeout 300
ONTIMEOUT local

MENU TITLE PXE Menu

LABEL Yocto
        MENU LABEL Yocto Build
        fdt zImage-imx6sx-udoo-neo-full.dtb
        kernel zImage-udooneo.bin
        append root=/dev/nfs rw nfsroot=<your-server-ip-here>:/tftpboot/rootfs/ ip=dhcp console=/dev/tty0 console=ttymxc0,115200 rootwait uart_from_osc clk_ignore_unused cpuidle.off=1 consoleblank=0
```

Finally, to boot your system, interrupt the U-Boot autoboot sequence by
pressing the space bar on your serial terminal while U-Boot is loading
and enter the following commands:

```
In:    serial
Out:   serial
Err:   serial
Net:   FEC0 [PRIME]
Hit any key to stop autoboot:  0
=> setenv autoload no
=> setenv serverip 192.168.1.32
=> dhcp
BOOTP broadcast 1
DHCP client bound to address 192.168.1.18 (65 ms)
=> pxe get
missing environment variable: pxeuuid
missing environment variable: bootfile
Retrieving file: pxelinux.cfg/01-00-c0-08-8c-88-dd
Using FEC0 device
TFTP from server 192.168.1.32; our IP address is 192.168.1.18
Filename 'pxelinux.cfg/01-00-c0-08-8c-88-dd'.
Load address: 0x82000000
Loading: #
         435.5 KiB/s
done
Bytes transferred = 446 (1be hex)
Config file found
=> pxe boot
PXE Menu
1:      Yocto Build
Enter choice: 1
```


Contributing
============

To contribute to this layer you should the patches for review to the
mailing list.


Source code:

    https://github.com/graugans/meta-udoo

When creating a patch of the last commit, use

    git format-patch -s --subject-prefix='meta-udoo][PATCH' -1

To send it to the community, use

    git send-email --to ch@ege.io <generated patch>

Patches are normally intended for the master branch.

Patches for other branches should be sent separately so they can be tracked
individually in Patchwork and should have the branch name in brackets.

For example, use this to generate a patch for branch 'dizzy':

    git format-patch -s \
	--subject-prefix='meta-udoo][dizzy][PATCH' -1
