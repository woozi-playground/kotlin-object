package org.woozi.practice.movie.adapter.out.mysql.mapper

import org.woozi.practice.movie.adapter.out.mysql.persistence.policy.DiscountPolicyEntity
import org.woozi.practice.movie.adapter.out.mysql.persistence.MovieEntity
import org.woozi.practice.movie.adapter.out.mysql.persistence.ShowingEntity
import org.woozi.practice.movie.adapter.out.mysql.persistence.policy.AmountDiscountPolicyEntity
import org.woozi.practice.movie.adapter.out.mysql.persistence.policy.PercentDiscountPolicyEntity
import org.woozi.practice.movie.adapter.out.mysql.persistence.policy.condition.PeriodDiscountConditionEntity
import org.woozi.practice.movie.adapter.out.mysql.persistence.policy.condition.SequenceDiscountConditionEntity
import org.woozi.practice.movie.domain.Money
import org.woozi.practice.movie.domain.Movie
import org.woozi.practice.movie.domain.Showing
import org.woozi.practice.movie.domain.policy.AmountDefaultDiscountPolicy
import org.woozi.practice.movie.domain.policy.DiscountPolicy
import org.woozi.practice.movie.domain.policy.NoneDefaultDiscountPolicy
import org.woozi.practice.movie.domain.policy.PercentDefaultDiscountPolicy
import org.woozi.practice.movie.domain.policy.condition.DiscountCondition
import org.woozi.practice.movie.domain.policy.condition.PeriodCondition
import org.woozi.practice.movie.domain.policy.condition.SequenceCondition

object ShowingMapper {

    fun toDomain(showingEntity: ShowingEntity): Showing = Showing(
        id = showingEntity.id.toString(),
        movie = toMovie(showingEntity.movieEntity),
        sequence = showingEntity.sequence,
        whenScreened = showingEntity.whenScreened
    )

    private fun toMovie(movieEntity: MovieEntity): Movie {
        return Movie(
            title = movieEntity.title,
            runningTime = movieEntity.runningTime,
            fee = Money(movieEntity.fee),
            discountPolicy = toPolicy(movieEntity.discountPolicy)
        )
    }

    private fun toPolicy(discountPolicy: DiscountPolicyEntity?): DiscountPolicy {
        if(discountPolicy == null) {
            return NoneDefaultDiscountPolicy()
        }
        return when(discountPolicy) {
            is AmountDiscountPolicyEntity -> {
                AmountDefaultDiscountPolicy(Money(discountPolicy.discountAmount), toCondition(discountPolicy))
            }
            is PercentDiscountPolicyEntity -> {
                PercentDefaultDiscountPolicy(discountPolicy.percent, toCondition(discountPolicy))
            }
            else -> {
                NoneDefaultDiscountPolicy()
            }
        }
    }

    private fun toCondition(discountPolicy: DiscountPolicyEntity): List<DiscountCondition> =
        discountPolicy.discountConditionEntities.map {
            when(it) {
                is PeriodDiscountConditionEntity -> {
                    PeriodCondition(it.dayOfWeek, it.startTime, it.endTime)
                }
                is SequenceDiscountConditionEntity -> {
                    SequenceCondition(it.sequence)
                }
                else -> {
                    throw IllegalArgumentException("Unsupported discount condition type: ${it::class.simpleName}")
                }
            }
        }
}