package org.woozi.practice.lecture

open class Lecture(
    private val title: String,
    private val pass: Int,
    private var _scores: List<Int> = ArrayList()
) {
    /** 전체 학생들의 성적을 리턴한다.  */
    val scores: List<Int> get() = _scores.toList()
    open val evaluationMethod: String get() = "Pass or Fail"

    /** 전체 학생들의 평균 성적을 리턴한다.  */
    fun average(): Double =
        _scores.stream()
            .mapToInt { it }
            .average()
            .orElse(0.0)

    /** 강의를 이수한 학생의 수와 낙제한 학생의 수를 형식에 맞게 구성한 문자열을 리턴한다.  */
    open fun evaluate(): String =
        "Pass:${passCount()} Fail:${failCount()}"

    private fun passCount(): Long =
        _scores.count { it >= pass }.toLong()

    private fun failCount(): Long =
        _scores.size - passCount()

    fun stats(): String =
        "Title: ${title}, Evaluation Method: $evaluationMethod"
}
