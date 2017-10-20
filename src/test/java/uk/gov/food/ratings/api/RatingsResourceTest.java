package uk.gov.food.ratings.api;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import uk.gov.food.ratings.api.data.Stub;
import uk.gov.food.ratings.api.domain.Establishment;
import uk.gov.food.ratings.api.domain.LocalAuthorities;
import uk.gov.food.ratings.api.domain.LocalAuthority;
import uk.gov.food.ratings.api.domain.RatingSummaries;
import uk.gov.food.ratings.api.domain.Region;
import uk.gov.food.ratings.api.domain.Regions;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * assertions are based on Stubbing from @see {@link uk.gov.food.ratings.api.data.Stub}
 */
public class RatingsResourceTest {

    private HttpServer server;
    private WebTarget target;
    private Stub stub;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
        stub = new Stub();
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void shouldGetRegions() {
        // given
        List<String> expectedRegionCodes = stub.regions.stream().map(Region::getName).collect(Collectors.toList());

        // when
        Regions actualRegions = target.path("regions").request().get(Regions.class);

        // then
        List<String> actualRegionCodes = actualRegions.getRegions().stream().map(Region::getName).collect(Collectors.toList());


        assertThat(actualRegionCodes.containsAll(expectedRegionCodes), is(true));

    }

    @Test
    public void shouldGetLocalAuthorities() {
        // given
        String region = "NORTH";
        // and
        List<String> expectedLocalAuthorityCodes = stub.localAuthorities.stream().filter(localAuthority -> localAuthority.getRegionName().equals(region)).map(LocalAuthority::getCode).collect(Collectors.toList());


        // when
        LocalAuthorities localAuthorities = target.path("regions/" + region + "/local-authorities").request().get(LocalAuthorities.class);

        // then
        List<String> actualLocalAuthorityCodes = localAuthorities.getLocalAuthorities().stream().map(LocalAuthority::getCode).collect(Collectors.toList());
        // and
        assertThat(actualLocalAuthorityCodes.containsAll(expectedLocalAuthorityCodes), is(true));
    }

    @Test
    public void shouldGetRatingsSummaryForAGivenLocalAuthority() {
        // given
        String region = "NORTH";
        // and
        String localAuthorityCode = "N-LA-A";
        // and
        List<String> expectedRatings = stub.establishments.stream().filter(establishment -> establishment.getLocalAuthorityBusinessID().equals(localAuthorityCode)).collect(Collectors.toList()).stream().map(Establishment::getRatingKey).collect(Collectors.toList());

        // when
        RatingSummaries ratingSummaries = target.path("regions/" + region + "/local-authorities/" + localAuthorityCode).request().get(RatingSummaries.class);

        // then
        List<String> actutalRatings = ratingSummaries.getRatingsSummaries().stream().map(ratingsSummary -> ratingsSummary.getRating().getKey()).collect(Collectors.toList());
        // and
        assertThat(actutalRatings.containsAll(expectedRatings), is(true));

    }
}
