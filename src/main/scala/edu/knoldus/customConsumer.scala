package edu.knoldus

import java.util.Properties

import org.apache.kafka.clients.consumer.KafkaConsumer

/**
 * Created by pallavi on 9/3/18.
 */
object customConsumer extends App {

  val props = new Properties
  //val producer =
  //props.put("auto.offset.reset", "earliest")
  //props.put("enable.auto.commit", "false")
  props.put("enable.auto.commit","false")
  props.put("auto.offset.reset","earliest")
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("group.id", "myGrp")



  val consumer = new KafkaConsumer[String, Student](props)
  consumer.subscribe(java.util.Collections.singletonList("topic"))
  while (true) {
    val records = consumer.poll(5000)
    for (record <- records.asScala)
      println(record.value())
  }

}
