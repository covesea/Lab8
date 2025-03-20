SUMMARY = "This is a base image created as example for courses"
inherit core-image

IMAGE_LINGUAS = " "

LICENSE = "MIT"

IMAGE_INSTALL:append = " \
    weston \
    matchbox-keyboard \
    cairo  \
    libgbm \
    libdrm \
    wayland \
    mesa \
    sensor-dash \
    usbutils \
    usbinit \
    "

IMAGE_FEATURES:append = " \
   ssh-server-openssh \
   splash \
   tools-debug \
   tools-sdk \
   "

IMAGE_BOOT_FILES = "${SPL_BINARYNAME} u-boot.${UBOOT_SUFFIX} tiboot3.bin k3-am625-beagleplay.dtb"

CORE_IMAGE_BASE_INSTALL += "gtk+3-demo"

DISTRO_FEATURES:append = " usbgadget wayland opengl pam x11"
MACHINE_FEATURES:append = " usbgadget usbhost"

CORE_IMAGE_BASE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland matchbox-terminal', '', d)}"


