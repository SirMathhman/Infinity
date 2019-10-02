name := "Infinity"

version := "1.0"

scalaVersion := "2.13.1"

libraryDependencies += "org.nanohttpd" % "nanohttpd" % "+"
libraryDependencies += "org.nanohttpd" % "nanohttpd-websocket" % "+"

libraryDependencies += "org.junit.jupiter" % "junit-jupiter-api" % "+" % Test
libraryDependencies += "org.junit.jupiter" % "junit-jupiter-engine" % "+" % Test
libraryDependencies += "org.junit.jupiter" % "junit-jupiter-params" % "+" % Test
libraryDependencies += "org.mockito" % "mockito-core" % "+" % Test