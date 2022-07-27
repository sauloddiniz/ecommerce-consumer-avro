package br.com

import br.com.consumer.NewOrderConsumerAvro

fun main() {
    val newOrder = NewOrderConsumerAvro();
    newOrder.createConsumer();
}
