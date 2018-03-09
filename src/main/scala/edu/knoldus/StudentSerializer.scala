package edu.knoldus

/**
 * Created by pallavi on 9/3/18.
 */

class StudentSerializer extends Nothing {
  def configure(map: Nothing, b: Boolean): Unit = {
  }

  def serialize(arg0: String, arg1: Nothing): Array[Byte] = {
    var retVal = null
    val objectMapper = new Nothing
    try
      retVal = objectMapper.writeValueAsString(arg1).getBytes
    catch {
      case e: Exception =>
        e.printStackTrace()
    }
    retVal
  }

  def close(): Unit = {
  }
}
