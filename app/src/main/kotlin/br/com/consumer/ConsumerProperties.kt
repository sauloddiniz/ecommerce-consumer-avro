package br.com.consumer

open class ConsumerProperties(private val idClass: String) {

    private val properties = mutableMapOf<String, String>()

    open fun createProperties(): MutableMap<String, String> {
        properties["key.deserializer"] = "org.apache.kafka.common.serialization.StringDeserializer";
        properties["value.deserializer"] = "io.confluent.kafka.serializers.KafkaAvroDeserializer"
        properties["bootstrap.servers"] = "localhost:9092";
        properties["max.poll.records"] = "1";
        properties["schema.registry.url"] = "http://127.0.0.1:8081"
        properties["group.id"] = idClass;
        return properties;
    }

}