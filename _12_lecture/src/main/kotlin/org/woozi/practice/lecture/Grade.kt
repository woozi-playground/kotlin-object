package org.woozi.practice.lecture

class Grade(
    val name: String,
    private val upper: Int,
    private val lower: Int
) {
    fun isName(name: String): Boolean =
        this.name == name

    fun include(score: Int): Boolean =
        score in lower..upper
}