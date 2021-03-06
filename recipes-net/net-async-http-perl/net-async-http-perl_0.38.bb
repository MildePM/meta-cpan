DESCRIPTION = "This object class implements an asynchronous HTTP user agent. It sends \
requests to servers, returning Future instances to yield responses when \
they \
are received. The object supports multiple concurrent connections to \
servers, and allows multiple requests in the pipeline to any one \
connection. \
Normally, only one such object will be needed per program to support \
any \
number of requests."

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-2.0"
PR = "r0"

MAINTAINER=	"Poky <poky@yoctoproject.org>"
HOMEPAGE=	"https://metacpan.org/release/Net-Async-HTTP"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "https://cpan.metacpan.org/authors/id/P/PE/PEVANS/Net-Async-HTTP-0.38.tar.gz"

SRC_URI[md5sum] = "18f2f14111d6e578910c7888694665bd"
SRC_URI[sha256sum] = "2abefd7ba4f51e58805172d9abb435385f945e9342083d3bbf65726ed2b83470"
RDEPENDS_${PN} += "future-perl"
RDEPENDS_${PN} += "http-message-perl"
RDEPENDS_${PN} += "io-async-perl"
RDEPENDS_${PN} += "struct-dumb-perl"
DEPENDS += "http-cookies-perl-native"
DEPENDS += "test-identity-perl-native"
DEPENDS += "test-refcount-perl-native"

S = "${WORKDIR}/Net-Async-HTTP-${PV}"

inherit cpan

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
	cpan_do_compile
}

BBCLASSEXTEND = "native"
