import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.1",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.4" % "compile",
    libraryDependencies += scalaTest % Test
  )
