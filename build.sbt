import com.dss.Dependencies._

lazy val root = (project in file("."))
  .enablePlugins(
    JavaAppPackaging,
    DockerPlugin
  )
  .settings(
    organization := "com.dss",
    name := "simple-scala-app",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.13.5",
    scalacOptions := compilerOptions,
    run / fork := true,
    Test / fork := true,
    libraryDependencies ++= Seq(
      Cats.effect,
      Http4s.blazeServer,
      Http4s.blazeClient,
      Http4s.dsl,
      Http4s.circe,
      Logging.log4cats,
      Logging.logbackclassic,
      Logging.logback,
      Logging.jackson,
      PureConfig.config,
  ), testFrameworks += new TestFramework("munit.Framework")
  )
  .settings(
  Docker / packageName := "simple-scala-app",
  dockerRepository := Some("insights.docker.artifactory.global.bamgrid.net"),
  dockerBaseImage := "insights.docker.artifactory.global.bamgrid.net/java:centos-correto-11",
  dockerExposedPorts := Seq(8080)
)
lazy val compilerOptions = Seq(
  "-deprecation", // Emit warning and location for usages of depreciated APIs
  "-encoding",
  "UTF-8", // Specify character encoding used by source files.
  "-language:higherKinds", // Allow higher-kinded types
  "-language:postfixOps",
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  //"-Xfatal-warnings", // Fail the compilation if there are any warnings.
  "-Ywarn-unused:imports", // Warn if an import selector is not referenced.  "-Ywarn-unused:locals", // Warn if a local definition is unused.
  "-Ywarn-unused:locals", // Warn if a local definition is unused.
  "-Ywarn-unused:params", // Warn if a value parameter is unused."
  "-P:splain:all:false", // Removes some of the redundancy of the compiler output and prints additional info for implicit resolution errors.
  "-Yrangepos" // required by SemanticDB compiler plugin which is used by scalafix
)

addCompilerPlugin("io.tryp" % "splain" % "0.5.8" cross CrossVersion.patch)
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
