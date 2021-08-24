package api

import cats.effect.{ContextShift, IO, Timer}
import io.circe.Json
import org.http4s.circe.jsonDecoder
import org.http4s.dsl.Http4sDsl
import org.http4s.implicits.http4sKleisliResponseSyntaxOptionT
import org.http4s.server.Router
import org.http4s.{HttpApp, HttpRoutes}
import service.MockService

object Api extends Http4sDsl[IO] {

  def routes(service: MockService): HttpRoutes[IO] =
    HttpRoutes.of[IO] {
      case GET -> Root / "post" / id =>
        Ok("pong")

      case request @ PUT -> Root / "post" / id => {
        request.decode[Json] {
          payload => service.putPost(id, payload)
        }

      }

    }

  def create(implicit contextShift: ContextShift[IO], timer: Timer[IO]): HttpApp[IO] =
    Router(
      "/http4s" -> Api.routes
    ).orNotFound

}
