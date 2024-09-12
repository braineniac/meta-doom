SUMMARY="Runs Doom"

LICENSE="CLOSED"

SRC_URI="git://github.com/wojciech-graj/doom-ascii.git;protocol=https;branch=master;"
SRCREV="052c25293b1a8cf5f3db06eeae89a5cd08111ed1"

SRC_URI:append=" https://distro.ibiblio.org/slitaz/sources/packages/d/doom1.wad"
SRC_URI[sha256sum] = "1d7d43be501e67d927e415e0b8f3e29c3bf33075e859721816f652a526cac771"

S = "${WORKDIR}/git"

do_configure[noexec] = "1"

do_compile () {
    cd ${S}/src
    oe_runmake
}

do_install () {
    install -d ${D}${bindir}
    install -m 0744 ${S}/doom_ascii/doom_ascii ${D}${bindir}/doom_ascii
    install -m 0744 ${WORKDIR}/doom1.wad ${D}${bindir}/DOOM1.WAD
}