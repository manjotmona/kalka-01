package edu.knoldus

import java.io.{ByteArrayInputStream, ObjectInputStream}

import org.apache.kafka.common.serialization.Deserializer

/**
 * Created by pallavi on 9/3/18.
 */

class StudentDeserializer extends Deserializer[Student]{

  override def configure(configs: java.util.Map[String,_],isKey: Boolean):Unit = {

  }
  override def deserialize(topic:String,bytes: Array[Byte]) = {
    val byteIn = new ByteArrayInputStream(bytes)
    val objIn = new ObjectInputStream(byteIn)
    val obj = objIn.readObject().asInstanceOf[Student]
    byteIn.close()
    objIn.close()
    obj
  }
  override def close():Unit = {

  }

}

