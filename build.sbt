name := "alpakka-xml-mapper"

version := "0.1.0"

scalaVersion := "2.12.4"

organizationName := "org.korbik"

libraryDependencies ++= Seq(
  "com.lightbend.akka" %% "akka-stream-alpakka-xml" % "0.17",
  "org.specs2" %% "specs2-core" % "4.0.2" % Test
)

scalacOptions in Test ++= Seq("-Yrangepos")