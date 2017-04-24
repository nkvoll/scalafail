package com.github.nkvoll.scalafail.nothing

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode

object NothingHmm {
  val mapper = new ObjectMapper()

  def main(args: Array[String]): Unit = {
    val clusterData = mapper.createObjectNode
    val repositoryNode = clusterData.putObject("snapshot").putObject("repository")
    repositoryNode.put("name", "test-repository")
    repositoryNode.putObject("config")
      .put("type", "foo")
      .putObject("settings").put("foo", "bar")

    //fails:
    val expectedConfig = repositoryNode.path("config").deepCopy()
    /*
    Exception in thread "main" java.lang.ClassCastException: com.fasterxml.jackson.databind.node.ObjectNode cannot be cast to scala.runtime.Nothing$
	at com.github.nkvoll.scalafail.nothing.NothingHmm$.main(NothingHmm.scala:17)
	at com.github.nkvoll.scalafail.nothing.NothingHmm.main(NothingHmm.scala)
     */

    // works:
    val expectedConfig2: ObjectNode = repositoryNode.path("config").deepCopy()
  }
}
