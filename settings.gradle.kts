plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "kotlin-object"
include(
    "_01_ticket",
    "_02_movie",
    "_03_movie_data",
    "lab",
    "lab:lab-movie",
    "lab:lab-order"
)
