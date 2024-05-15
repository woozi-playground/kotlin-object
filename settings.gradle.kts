plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "kotlin-object"
include(
    "object",
    "object:_01_ticket",
    "object:_02_movie",
    "object:_04_movie_data",
    "object:_05_movie",
    "object:_05_movie_refactoring",
    "object:_06_command_query",
    "object:_06_refactoring",
    "object:_10_call",
    "object:_11_call",
    "object:_12_lecture",
    "object:_14_call_charge",
    "lab",
    "lab:lab-movie",
    "lab:lab-order"
)
