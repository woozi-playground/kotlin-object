package org.woozi.practice.laborder.shop.domain

data class OptionGroupSpecification(
    val id: Long,
    val name: String,
    val exclusive: Boolean,
    val basic: Boolean,
    val optionSpecs: List<OptionSpecification>
) {

    fun isSatisfiedBy(optionGroup: OptionGroup): Boolean =
        !isSatisfied(optionGroup.name, satisfied(optionGroup.options))

    private fun isSatisfied(groupName: String, satisfied: List<Option>): Boolean {
        if (name != groupName) {
            return false
        }

        if (satisfied.isEmpty()) {
            return false
        }

        if (exclusive && satisfied.size > 1) {
            return false
        }

        return true
    }

    private fun satisfied(options: List<Option>): List<Option> =
        optionSpecs.flatMap { spec -> options.filter(spec::isSatisfiedBy) }
}
