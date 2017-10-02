package uk.gov.food.ratings.api

//#test-top
import akka.actor.ActorRef
import akka.http.scaladsl.marshalling.Marshal
import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{ Matchers, WordSpec }

//#set-up
class LocalAuthorityRoutesSpec extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest
    with LocalAuthorityRoutes {
  //#test-top

  // Here we need to implement all the abstract members of LocalAuthorityRoutes.
  // We use the real LocalAuthorityActor to test it while we hit the Routes,
  // but we could "mock" it by implementing it in-place or by using a TestProbe()
  override val localAuthorityActor: ActorRef =
    system.actorOf(LocalAuthorityActor.props, "localAuthorityRatings")

  lazy val routes = localAuthorityRoutes

  //#set-up

  //#actual-test
  "LocalAuthorityRoutes" should {
    "return no local authorities if no present (GET /local-authorities)" in {
      // note that there's no need for the host part in the uri:
      val request = HttpRequest(uri = "/local-authorities")

      request ~> routes ~> check {
        status should ===(StatusCodes.OK)

        // we expect the response to be json:
        contentType should ===(ContentTypes.`application/json`)

        // and no entries should be in the list:
        entityAs[String] should ===("""{"localAuthorities":[]}""")
      }
    }
    //#actual-test

    //#testing-post
    "be able to add local authority (POST /local-authorities)" in {
      val localAuthority = LocalAuthority("Enfield")
      val localAuthorityEntity = Marshal(localAuthority).to[MessageEntity].futureValue // futureValue is from ScalaFutures

      // using the RequestBuilding DSL:
      val request = Post("/local-authorities").withEntity(localAuthorityEntity)

      request ~> routes ~> check {
        status should ===(StatusCodes.Created)

        // we expect the response to be json:
        contentType should ===(ContentTypes.`application/json`)

        // and we know what message we're expecting back:
        entityAs[String] should ===("""{"description":"LocalAuthority Enfield created."}""")
      }
    }
    //#testing-post

    "be able to remove local authority (DELETE /local-authorities)" in {
      // using the RequestBuilding DSL provided by ScalatestRouteSpec:
      val request = Delete(uri = "/local-authorities/Enfield")

      request ~> routes ~> check {
        status should ===(StatusCodes.OK)

        // we expect the response to be json:
        contentType should ===(ContentTypes.`application/json`)

        // and no entries should be in the list:
        entityAs[String] should ===("""{"description":"LocalAuthority Enfield deleted."}""")
      }
    }
    //#actual-test

    //#testing-ratings-post
    "be able to add local authority (POST /local-authorities/Enfield/ratings)" in {
      val localAuthorityRatings = LocalAuthorityRatings(LocalAuthority("Enfield"), Set(("A", FiveStar)))
      val localAuthorityRatingsEntity = Marshal(localAuthorityRatings).to[MessageEntity].futureValue // futureValue is from ScalaFutures

      // using the RequestBuilding DSL:
      val request = Post("/local-authorities/Enfield/ratings").withEntity(localAuthorityRatingsEntity)

      request ~> routes ~> check {
        status should ===(StatusCodes.Created)

        // we expect the response to be json:
        contentType should ===(ContentTypes.`application/json`)

        // and we know what message we're expecting back:
        entityAs[String] should ===("""{"description":"LocalAuthority Ratings for Enfield created."}""")
      }
    }
    //#testing-ratings-post
  }
  //#actual-test

  //#set-up
}

//#set-up
