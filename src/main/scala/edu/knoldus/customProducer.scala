package edu.knoldus

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

/**
 * Created by pallavi on 6/3/18.
 */
//case class edu.knoldus.Student(id: Int, name: String)
object customProducer  extends App{

  val props = new Properties
  //val producer =
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val sendStudent = Student(1,"mona")
  val producer = new KafkaProducer[String,Student](props)

  val record = new ProducerRecord[String,Student]("topic","key",sendStudent)
  producer.send(record)

  println("send")
  producer.close()


}
