package com.github.nkvoll.scalafail.pkg2

import com.github.nkvoll.scalafail.pkg.java.AnotherJavaClass

object HelloPackagePrivateClass {
  def main(args: Array[String]): Unit = {
    val packagePrivateJavaClass = AnotherJavaClass.returnPackageClass()

    // somehow scala allows us to reference this, the class is inferred to be a `PackagePrivateJavaClass`, even though
    // we cannot reference that class from here (so we can't even add an explicit type annotation to the above statement)
    println(s"Got reference: [$packagePrivateJavaClass]")

    // attempt to say hello, this compiles fine, but fails at runtime
    packagePrivateJavaClass.sayHello()
  }
}
