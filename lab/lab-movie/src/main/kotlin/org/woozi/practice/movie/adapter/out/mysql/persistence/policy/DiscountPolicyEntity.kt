package org.woozi.practice.movie.adapter.out.mysql.persistence.policy

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorColumn
import jakarta.persistence.DiscriminatorType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.woozi.practice.movie.adapter.out.mysql.persistence.policy.condition.DiscountConditionEntity

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discount_policy_type")
@Table(name = "discount_policy")
@Entity
abstract class DiscountPolicyEntity(

    @OneToMany(mappedBy = "discountPolicyEntity", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var discountConditionEntities: MutableList<DiscountConditionEntity> = mutableListOf(),

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
) {
    @Column(name = "discount_policy_type", insertable = false, updatable = false)
    abstract fun discountPolicyType(): DiscountPolicyEntityType
}