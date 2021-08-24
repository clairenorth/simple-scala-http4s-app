package service

import io.circe.Json

trait MockService {

  def getPost(id: String)

  def putPost(id: String, payload: Json)
}
