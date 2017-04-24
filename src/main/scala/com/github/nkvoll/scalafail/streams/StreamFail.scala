package com.github.nkvoll.scalafail.streams

import java.util
import java.util.stream.Collectors

object StreamFail {
  def main(args: Array[String]): Unit = {
    val foo: java.util.List[String] = new util.LinkedList[String]()

    foo.add("1")
    foo.add("2")

    val append3 = new java.util.function.Function[String, String] {
      override def apply(t: String): String = t + "-3"
    }

    // does not compile:
    //val foosWith3 = foo.stream().map(append3).collect(Collectors.toList)
    /*
    Error:(20, 64) type mismatch;
   found   : java.util.stream.Collector[Nothing,?0(in value foosWith3),java.util.List[Nothing]] where type ?0(in value foosWith3)
   required: java.util.stream.Collector[_ >: ?0(in value x$1), ?, ?]
  Note: Nothing <: Any, but Java-defined trait Collector is invariant in type T.
  You may wish to investigate a wildcard type such as `_ <: Any`. (SLS 3.2.10)
    val foosWith3 = foo.stream().map(append3).collect(Collectors.toList)
     */


    // shows up as valid in idea, but doesn't actually compile
    //val foosWith3 = foo.stream().map(append3).collect(Collectors.toList[String])

    // valid and compiles:
    val foosWith3 = (foo.stream().map(append3): java.util.stream.Stream[String]).collect(Collectors.toList[String])

    println(foosWith3)
  }
}
