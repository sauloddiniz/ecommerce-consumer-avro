package br.com.consumer

import br.example.dto.OrderAvro
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.time.Duration
import java.util.Collections

class NewOrderConsumerAvro {

    private val topic = "ECOMMERCE_AVRO";

    fun createConsumer() {
        val properties = ConsumerProperties(
            NewOrderConsumerAvro::class.java.simpleName
        ).createProperties();
        val consumer: KafkaConsumer<String, OrderAvro> =
            KafkaConsumer<String, OrderAvro>(properties as Map<String, Any>?);
        consumer.subscribe(Collections.singletonList(topic));

        while (true) {
            var records = consumer.poll(Duration.ofMillis(100))
            if (!records.isEmpty) {
                for (record in records) {
                    println("item : ${record.value()}")
                    Thread.sleep(2000);
                }
            }
        }
    }

}