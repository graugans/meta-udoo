ext2load ${devtype} ${devnum}:${distro_bootpart} ${fdt_addr_r} /boot/${fdtfile}
ext2load ${devtype} ${devnum}:${distro_bootpart} ${kernel_addr_r} /boot/zImage
setenv mmcroot /dev/mmcblk${devnum}p${distro_bootpart} rootwait rw
setenv m4mmcargs uart_from_osc clk_ignore_unused cpuidle.off=1
setenv bootargs console=${console},${baudrate} root=${mmcroot} rootfstype=${mmcrootfstype} ${m4mmcargs} consoleblank=0
bootz ${kernel_addr_r} - ${fdt_addr}
