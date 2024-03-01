package org.woozi.practice.laborder.order.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderEntityRepository : JpaRepository<OrderEntity, Long>