SUMMARY = "dial for 4g m5700"
DESCRIPTION = "dial for 4g m5700"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://licenses/GPL-2;md5=94d55d512a9ba36caa9b7df079bae19f"
PV = "0.1"
PR = "v1"

SRC_URI = "file://sbin/ecm \
           file://licenses/GPL-2 \
          "
          
S = "${WORKDIR}"

dirs755= "/sbin "

					

do_install (){
	for d in ${dirs755}; do
		install -m 0755 -d ${D}$d
	done
	
	install -m 0755 ${WORKDIR}/sbin/ecm ${D}/sbin/ecm

	
}



FILES:${PN} = "/"

