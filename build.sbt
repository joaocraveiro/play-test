name := """play-test"""

version := "0.1"

lazy val root = (project in file(".")).enablePlugins(PlayJava, SbtWeb)

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  guice,
  javaWs,   
  "org.neo4j" % "neo4j-ogm-bolt-driver" % "3.0.1",
  "org.neo4j" % "neo4j-ogm-core" % "3.0.1"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

// Javadoc
sources in (Compile, doc) ~= (_ filter (_.getName endsWith ".java"))