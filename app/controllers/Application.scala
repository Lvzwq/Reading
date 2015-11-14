package controllers

import play.api._
import play.api.libs.iteratee.Enumerator
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def test = Action {
    Ok("Hello world")
  }

  def hello(name: String) = Action {
    Ok("hello + " + name)
  }

  def helloworld = Action {
    Result(header = ResponseHeader(200, Map(CONTENT_TYPE -> "text/plain")), body = Enumerator("Hello World".getBytes()))
  }

  def file(name: String) = Action{
    Ok(name)
  }


}