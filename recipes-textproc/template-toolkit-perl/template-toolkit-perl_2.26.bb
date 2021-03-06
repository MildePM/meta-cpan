DESCRIPTION = "This documentation describes the Template module which is the direct \
Perl interface into the Template Toolkit. It covers the use of the \
module and \
gives a brief summary of configuration options and template directives. \
Please see Template::Manual for the complete reference manual which \
goes \
into much greater depth about the features and use of the Template \
Toolkit. \
The Template::Tutorial is also available as an introductory guide to \
using \
the Template Toolkit."

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-2.0"
PR = "r0"

MAINTAINER=	"Poky <poky@yoctoproject.org>"
HOMEPAGE=	"https://metacpan.org/release/Template-Toolkit"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://cpan.metacpan.org/authors/id/A/AB/ABW/Template-Toolkit-2.26.tar.gz"

SRC_URI[md5sum] = "4c289856ebee446ebbe2629b24f0734b"
SRC_URI[sha256sum] = "e7e1cf36026f1ef96d8233e18a3fb39e1eafe9109edc639ecf25b20651cd76be"
RDEPENDS_${PN} += "appconfig-perl"

S = "${WORKDIR}/Template-Toolkit-${PV}"

inherit cpan

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
	cpan_do_compile
}

BBCLASSEXTEND = "native"
