package org.woozi.practice.movie.adapter.out.mysql.persistence

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.woozi.practice.movie.adapter.out.mysql.persistence.policy.DiscountPolicyEntity
import java.math.BigDecimal

@Table(name = "movie")
@Entity
class MovieEntity(

    var title: String,
    var runningTime: Long,
    var fee: BigDecimal,

    @OneToOne
    var discountPolicy: DiscountPolicyEntity? = null,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
) {
}