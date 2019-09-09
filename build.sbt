name := "Infinity"

version := "1.0"

scalaVersion := "2.12.7"

// https://mvnrepository.com/artifact/org.nanohttpd/nanohttpd
libraryDependencies += "org.nanohttpd" % "nanohttpd" % "+"

libraryDependencies += "org.junit.jupiter" % "junit-jupiter-api" % "+" % Test
libraryDependencies += "org.junit.jupiter" % "junit-jupiter-engine" % "+" % Test
libraryDependencies += "org.junit.jupiter" % "junit-jupiter-params" % "+" % Test
libraryDependencies += "org.mockito" % "mockito-core" % "+" % Test