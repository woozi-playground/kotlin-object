package org.woozi.practice.movie.adapter.out.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import org.woozi.practice.movie.application.port.out.DomainEventPublisher
import org.woozi.practice.movie.domain.common.DomainEvent

@Component
class KafkaPublisher(
    private val kafkaTemplate: KafkaTemplate<String, String>
): DomainEventPublisher {

    override fun publishEvent(domainEvent: DomainEvent) {
        kafkaTemplate.send("movie", domainEvent.toString())
    }
}