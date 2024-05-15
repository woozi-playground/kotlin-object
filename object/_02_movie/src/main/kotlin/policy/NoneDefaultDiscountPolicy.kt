package policy

import Money
import Screening

class NoneDefaultDiscountPolicy : DiscountPolicy {
    override fun calculateDiscountAmount(screening: Screening): Money =
        Money.ZERO
}
