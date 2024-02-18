package org.woozi.practice.movie.adapter.out.mysql.persistence.policy.condition

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorColumn
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.woozi.practice.movie.adapter.out.mysql.persistence.policy.DiscountPolicyEntity

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "condition_type")
@Table(name = "discount_condition")
@Entity
abstract class DiscountConditionEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_policy_id")
    var discountPolicyEntity: DiscountPolicyEntity? = null,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
) {
    @Column(name = "condition_type", updatable = false)
    abstract fun conditionType(): DiscountConditionEntityType
}