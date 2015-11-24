package controllers

import play.api.db.DB
import play.api.libs.iteratee.Enumerator
import play.api.mvc._
import play.api.Play.current


object Application extends Controller {

  def index = Action { implicit request =>
    Ok(views.html.index("Your new application is ready."))
  }


  def test = Action {
    val conn = DB.getConnection()
    try {
      val stmt = conn.createStatement()
      val rs = stmt.executeQuery("select * from wp_posts")
      while (rs.next()) {
        println(rs.getString("post_title"))
        println(rs.getString("post_content"))
      }
    } finally {
      conn.close()
    }
    Ok("Hello world")
  }

  def hello(name: String) = Action {
    Ok("hello + " + name)
  }

  def helloworld = Action {
    Result(header = ResponseHeader(200, Map(CONTENT_TYPE -> "text/plain")), body = Enumerator("Hello World".getBytes()))
  }

  def file(name: String) = Action {
    Ok(name)
  }

  def save = Action { request =>
    val body = request.body
    val textBody: Option[String] = body.asText
    println("hello" + textBody)
    textBody.map { text =>
      Ok("Got :" + text)
    }.getOrElse {
      BadRequest("Expecting text/plain request body")
    }

  }


}