FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}/st-1.18.0:"

SRC_URI:append = " \
    file://0001-Add-autogen.sh.patch \
    file://0002-Correct-X11-dependency.patch \
"

