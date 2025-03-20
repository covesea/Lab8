SUMMARY = "Labtest build"

LICENSE = "CLOSED"

SRC_URI = "git://github.com/ancor1369/simple-library.git;protocol=https;branch=main"

SRCREV = "1e2f9bf03244fa37187482dbfa95d676ae84df6c"

S = "${WORKDIR}/git" 

inherit cmake

DEPENDS = "nlohmann-json gtest spdlog"

do_install() {
	install -d ${D}{bindir}
	install -m 0755 tests/simple-library-test ${D}{bindir}/
}

FILES_${PN} = "${D}"
