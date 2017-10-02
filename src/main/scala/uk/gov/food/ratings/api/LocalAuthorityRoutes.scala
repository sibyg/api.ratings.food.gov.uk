package uk.gov.food.ratings.api

import akka.actor.{ ActorRef, ActorSystem }
import akka.event.Logging
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.directives.MethodDirectives.{ delete, get, post }
import akka.http.scaladsl.server.directives.PathDirectives.path
import akka.http.scaladsl.server.directives.RouteDirectives.complete
import akka.pattern.ask
import akka.util.Timeout
import uk.gov.food.ratings.api.LocalAuthorityActor._

import scala.concurrent.Future
import scala.concurrent.duration._

trait LocalAuthorityRoutes extends JsonSupport {

  implicit def system: ActorSystem

  lazy val log = Logging(system, classOf[LocalAuthorityRoutes])

  def localAuthorityActor: ActorRef

  implicit lazy val timeout = Timeout(5.seconds)

  //#all-routes
  lazy val localAuthorityRoutes: Route =
    pathPrefix("local-authorities") {
      concat(
        pathEnd {
          concat(
            get {
              val localAuthorities: Future[LocalAuthorities] =
                (localAuthorityActor ? GetLocalAuthorities).mapTo[LocalAuthorities]
              complete(localAuthorities)
            },
            post {
              entity(as[LocalAuthority]) { localAuthority =>
                val localAuthorityCreated: Future[ActionPerformed] =
                  (localAuthorityActor ? CreateLocalAuthority(localAuthority)).mapTo[ActionPerformed]
                onSuccess(localAuthorityCreated) { performed =>
                  log.info("Created localAuthority [{}]: {}", localAuthority.id, performed.description)
                  complete((StatusCodes.Created, performed))
                }
              }
            }
          )
        },
        path(Segment) { id =>
          concat(
            get {
              val maybeLocalAuthority: Future[Option[LocalAuthority]] =
                (localAuthorityActor ? GetLocalAuthority(id)).mapTo[Option[LocalAuthority]]
              rejectEmptyResponse {
                complete(maybeLocalAuthority)
              }
            },
            delete {
              val localAuthorityDeleted: Future[ActionPerformed] =
                (localAuthorityActor ? DeleteLocalAuthority(id)).mapTo[ActionPerformed]
              onSuccess(localAuthorityDeleted) { performed =>
                log.info("Deleted local-authority [{}]: {}", id, performed.description)
                complete((StatusCodes.OK, performed))
              }
            },
            pathPrefix("ratings") {
              pathEnd {
                concat(
                  post {
                    entity(as[LocalAuthorityRatings]) { localAuthorityRatings =>
                      val localAuthorityRatingsCreated: Future[ActionPerformed] =
                        (localAuthorityActor ? CreateLocalAuthorityRatings(localAuthorityRatings)).mapTo[ActionPerformed]
                      onSuccess(localAuthorityRatingsCreated) { performed =>
                        log.info("Created localAuthority Ratings for [{}]: {}", localAuthorityRatings.localAuthority.id, performed.description)
                        complete((StatusCodes.Created, performed))
                      }
                    }
                  }
                )
              }
            }
          )
        }
      )
    }

  //#all-routes
}
