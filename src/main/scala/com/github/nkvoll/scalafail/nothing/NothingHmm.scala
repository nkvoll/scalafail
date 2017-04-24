package com.github.nkvoll.scalafail.nothing

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode

object NothingHmm {
  val mapper = new ObjectMapper()

  def main(args: Array[String]): Unit = {
    val rootNode = mapper.createObjectNode
    val configNode = rootNode.putObject("foo").putObject("config")

    // compiles, fails at runtime:
    val expectedConfig = rootNode.path("foo").deepCopy()
    /*
    Exception in thread "main" java.lang.ClassCastException: com.fasterxml.jackson.databind.node.ObjectNode cannot be cast to scala.runtime.Nothing$
	at com.github.nkvoll.scalafail.nothing.NothingHmm$.main(NothingHmm.scala:17)
	at com.github.nkvoll.scalafail.nothing.NothingHmm.main(NothingHmm.scala)
     */

    // compiles and works:
    val expectedConfig2: ObjectNode = rootNode.path("foo").deepCopy()

    println(expectedConfig2)
  }
}
