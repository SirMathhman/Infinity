name := "Infinity"

version := "1.0"

scalaVersion := "2.12.7"

mainClass in(Compile, run) := Some("com.meti.app.execute.ClientExecutor")

libraryDependencies += "org.openjfx" % "javafx" % "12.0.1"
libraryDependencies += "org.junit.jupiter" % "junit-jupiter-api" % "5.+" % Test
libraryDependencies += "org.junit.jupiter" % "junit-jupiter-engine" % "5.+" % Test
libraryDependencies += "org.junit.jupiter" % "junit-jupiter-params" % "5.+" % Test
libraryDependencies += "org.mockito" % "mockito-core" % "2.+" % Test