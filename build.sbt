import AssemblyKeys._

name := "myserver"

version := "0.1.0"

scalaVersion := "2.9.2"

mainClass := Some("server.BasicServer")

resolvers += "Sonatype Releases Repository" at "http://oss.sonatype.org/content/repositories/releases"

resolvers += "Twitter Maven Repository" at "http://maven.twttr.com"

resolvers += "Maven Repository" at "http://mvnrepository.com/artifact/"

libraryDependencies+= "org.specs2" %% "specs2" % "1.11" % "test"

libraryDependencies += "com.twitter" %% "twitter-server" % "1.0.1"

seq(assemblySettings: _*)

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  {
    case _ => MergeStrategy.last // leiningen build files
  }
}

excludedFiles in assembly := { (bases: Seq[File]) =>
  bases flatMap { base =>
    //Exclude all log4j.properties from other peoples jars
    ((base * "*").get collect {
      case f if f.getName.toLowerCase == "log4j.properties" => f
    }) ++
    //Exclude the license and manifest from the exploded jars
    ((base / "META-INF" * "*").get collect {
      case f if List("manifest.mf", "notice.txt", "license.txt").contains(f.getName.toLowerCase) => f
    })
  }
}
