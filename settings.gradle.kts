plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "kotlin-object"
include(
    "_01_ticket",
    "_02_movie",
    "_04_movie_data",
    "_05_movie",
    "_05_movie_refactoring",
    "_06_cqrs",
    "lab",
    "lab:lab-movie",
    "lab:lab-order"
)
