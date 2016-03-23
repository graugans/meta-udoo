FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += " \
 file://dont_try_build_with_SSLv2_when_it_is_not_available.patch \
"

SWIG_FEATURES_append = " -DOPENSSL_NO_SSL2"
export SWIG_FEATURES
