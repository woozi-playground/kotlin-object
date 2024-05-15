package org.woozi.practice.lecture

import java.lang.String.*

class FormattedGradeLecture(
    name: String,
    pass: Int,
    grades: List<Grade>,
    scores: List<Int>
) : GradeLecture(name, pass, grades, scores) {

    fun formatAverage(): String {
        return format("Avg: %1.1f", super.average())
    }
}