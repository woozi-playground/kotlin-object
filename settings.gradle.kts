plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "kotlin-object"
include("chap1")
include("chap2")
include("lab")
include("lab:lab-movie")
include("lab:lab-order")
