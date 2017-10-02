package uk.gov.food.ratings.api

import akka.actor.{ Actor, ActorLogging, Props }

abstract class FoodRating

case object FiveStar extends FoodRating

case object FourStar extends FoodRating

case object ThreeStar extends FoodRating

case object TwoStar extends FoodRating

case object OneStar extends FoodRating

case object Exempt extends FoodRating

final case class LocalAuthority(id: String)

final case class LocalAuthorities(localAuthorities: Seq[LocalAuthority])

final case class LocalAuthorityRatings(
  localAuthority: LocalAuthority,
  establishmentRatings: Set[(String, FoodRating)]
)

object LocalAuthorityActor {

  final case class ActionPerformed(description: String)

  final case object GetLocalAuthorities

  final case class CreateLocalAuthority(localAuthority: LocalAuthority)

  final case class CreateLocalAuthorityRatings(localAuthorityRatings: LocalAuthorityRatings)

  final case class GetLocalAuthority(id: String)

  final case class DeleteLocalAuthority(id: String)

  def props: Props = Props[LocalAuthorityActor]
}

class LocalAuthorityActor extends Actor with ActorLogging {

  import LocalAuthorityActor._

  var localAuthorities = Set.empty[LocalAuthority]
  var localAuthorityRatings = Set.empty[LocalAuthorityRatings]

  def receive: Receive = {
    case GetLocalAuthorities =>
      sender() ! LocalAuthorities(localAuthorities.toSeq)
    case CreateLocalAuthority(localAuthority) =>
      localAuthorities += localAuthority
      sender() ! ActionPerformed(s"LocalAuthority ${localAuthority.id} created.")
    case CreateLocalAuthorityRatings(localAuthorityRating) =>
      localAuthorityRatings += localAuthorityRating
      sender() ! ActionPerformed(s"LocalAuthority Ratings for ${localAuthorityRating.localAuthority.id} created.")
    case GetLocalAuthority(id) =>
      sender() ! localAuthorities.find(_.id == id)
    case DeleteLocalAuthority(id) =>
      localAuthorities.find(_.id == id) foreach { localAuthority => localAuthorities -= localAuthority }
      sender() ! ActionPerformed(s"LocalAuthority $id deleted.")
  }
}