
import cats.effect._
import org.http4s.server.blaze.BlazeServerBuilder
import api.Api

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    val app = Api.create
    BlazeServerBuilder[IO](global)
      .bindHttp(8080)
      .withHttpApp(app)
      .resource
      .use(_ => IO.never)
      .as(ExitCode.Success)
  }

}