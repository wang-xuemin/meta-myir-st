SUMMARY = "3D cube for wayland/weston windows"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=23e79a8a8bc2486f30a780e6f8de22c4"

SRC_URI = "git://github.com/STMicroelectronics/st-openstlinux-application.git;protocol=https;branch=master"

# Modify these as desired
PV = "4.0+git${SRCPV}"
SRCREV = "cd44839e95af8c1dc80bb16270bcc6e938545849"

DEPENDS += "wayland wayland-native wayland-protocols libdrm pixman libpng libjpeg-turbo \
	virtual/egl virtual/libgles2 gstreamer1.0 gstreamer1.0-plugins-base"

# Needed to update dynamic library name in elf file
DEPENDS += "patchelf-native"

inherit meson pkgconfig

S = "${WORKDIR}/git/weston-cube"

do_install () {
	install -d ${D}${prefix}/local/demo/bin
	install -m 0755 ${B}/weston-st-egl-cube-tex ${D}${prefix}/local/demo/bin/
	# Fix wrong library name in bin file
	if [ ${PREFERRED_PROVIDER_virtual/egl} = "mesa" ]; then
	    patchelf --replace-needed libEGL.so libEGL.so.1 ${D}${prefix}/local/demo/bin/weston-st-egl-cube-tex
	fi
	if [ ${PREFERRED_PROVIDER_virtual/libgles2} = "mesa" ]; then
	    patchelf --replace-needed libGLESv2.so libGLESv2.so.2 ${D}${prefix}/local/demo/bin/weston-st-egl-cube-tex
	fi
}
FILES:${PN} += "${prefix}/local/demo/bin"
