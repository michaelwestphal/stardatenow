package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import models.Stardate

object Application extends Controller {
  
  def index = Action {
    Redirect("/now")
  }
  
  def now = Action { implicit request =>
    render {
      case Accepts.Html() => Ok(views.html.index(Stardate.now))
      case Accepts.Json() => Ok(Json.toJson(Stardate.now))
    }
  }
  
  implicit val stardateWrites = new Writes[Stardate] {
	  def writes(sd: Stardate): JsValue = {
	    Json.obj(
	    	"stardate" -> sd.toString
	    )
	  }
	}
  
}