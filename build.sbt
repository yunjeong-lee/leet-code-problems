scalaVersion := "2.13.0"

scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test

/*
lazy val scalacheck = "org.scalacheck" %% "scalacheck" % "1.14.1"
libraryDependencies += scalacheck % Test
*/

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.1"

testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-a", "-v", "-s")
