package uk.gov.food.ratings.api

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol
import uk.gov.food.ratings.api.LocalAuthorityActor.ActionPerformed

trait JsonSupport extends SprayJsonSupport {
  // import the default encoders for primitive types (Int, String, Lists etc)
  import DefaultJsonProtocol._

  implicit val localAuthorityJsonFormat = jsonFormat1(LocalAuthority)
  implicit val localAuthorityRatingsJsonFormat = jsonFormat2(LocalAuthorityRatings)
  implicit val localAuthoritiesJsonFormat = jsonFormat1(LocalAuthorities)
  implicit val actionPerformedJsonFormat = jsonFormat1(ActionPerformed)
}
