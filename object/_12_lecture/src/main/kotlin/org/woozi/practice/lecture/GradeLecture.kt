package org.woozi.practice.lecture

open class GradeLecture(
    title: String,
    pass: Int,
    grades: List<Grade>,
    scores: List<Int>
) : Lecture(title, pass, scores) {

    private val grades: List<Grade> = grades

    override fun evaluate(): String =
        "${super.evaluate()}, ${gradeStatistics()}"

    private fun gradeStatistics(): String {
        return grades.joinToString(separator = " ", transform = ::format)
    }

    private fun format(grade: Grade): String =
        "${grade.name}:${gradeCount(grade)}"

    private fun gradeCount(grade: Grade): Long =
        scores.count(grade::include).toLong()

    fun average(gradeName: String): Double =
        grades
            .firstOrNull { it.isName(gradeName) }
            ?.let(this::gradeAverage)
            ?: 0.0

    private fun gradeAverage(grade: Grade): Double {
        return scores.stream()
            .filter(grade::include)
            .mapToInt { it }
            .average()
            .orElse(0.0)
    }

    override val evaluationMethod: String get() = "Grade"
}