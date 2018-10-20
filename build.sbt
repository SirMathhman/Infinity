name := "Infinity"

version := "0.1"

scalaVersion := "2.12.7"

mainClass in (Compile, run) := Some("com.meti.Main")

libraryDependencies += "org.junit.jupiter" % "junit-jupiter-api" % "5.3.1" % Test
libraryDependencies += "org.junit.jupiter" % "junit-jupiter-engine" % "5.3.1" % Test
libraryDependencies += "org.junit.jupiter" % "junit-jupiter-params" % "5.3.1" % Test
libraryDependencies += "org.testfx" % "testfx-core" % "4.0.15-alpha" % Test
libraryDependencies += "org.testfx" % "testfx-junit5" % "4.0.15-alpha" % Test