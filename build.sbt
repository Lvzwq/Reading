name := "playScalaIntro"

version := "1.0"

lazy val `playscalaintro` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq( jdbc , cache , ws   , specs2 % Test , "net.sf.barcode4j" % "barcode4j" % "2.0")

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"


fork in run := true