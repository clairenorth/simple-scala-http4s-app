package com.dss

import sbt._

/** Dependencies referenced in project auto-plugin and build code
  */

object Dependencies {

  object Cats {
    val CatsEffectVersion = "2.3.3"
    val effect = "org.typelevel" %% "cats-effect" % CatsEffectVersion
  }
  object Http4s {
    val http4sVersion = "0.21.20"
    val blazeServer = "org.http4s" %% "http4s-blaze-server" % http4sVersion
    val blazeClient = "org.http4s" %% "http4s-blaze-client" % http4sVersion
    val dsl = "org.http4s" %% "http4s-dsl" % http4sVersion
    val circe = "org.http4s" %% "http4s-circe" % http4sVersion
  }

  object Logging {
    val logbackEncoderVersion = "6.6"
    val logbackVersion = "1.2.3"
    val log4CatsVersion = "1.2.1"
    val jacksonVersion = "2.12.2"
    val log4cats = "org.typelevel" %% "log4cats-slf4j" % log4CatsVersion
    val logbackclassic = "ch.qos.logback" % "logback-classic" % logbackVersion

    val logback =
      "net.logstash.logback" % "logstash-logback-encoder" % logbackEncoderVersion

    val jackson =
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonVersion

  }

  object PureConfig {
    val pureConfigVersion = "0.15.0"
    val config = "com.github.pureconfig" %% "pureconfig" % pureConfigVersion
  }


  object Testing {
    val munit = "org.scalameta" %% "munit" % "0.7.26" % Test
  }
}
