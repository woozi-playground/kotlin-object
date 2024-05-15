package org.woozi.practice.lecture

fun main() {
    val lecture = FormattedGradeLecture("객체지향 프로그래밍", 70,
        listOf(
            Grade("A", 100, 90),
            Grade("B", 89, 80),
            Grade("C", 79, 70),
            Grade("D", 69, 60),
            Grade("F", 59, 0)
        ),
        listOf(100, 50, 70, 60)
    )
    println(lecture.formatAverage())
    println(lecture.average())
    println(lecture.stats())
    println(lecture.evaluate())
}