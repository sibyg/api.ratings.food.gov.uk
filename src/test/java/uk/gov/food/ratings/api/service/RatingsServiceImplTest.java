package uk.gov.food.ratings.api.service;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.mockito.BDDMockito.given;

import uk.gov.food.ratings.api.dao.RatingsDao;
import uk.gov.food.ratings.api.domain.Establishment;
import uk.gov.food.ratings.api.domain.LocalAuthority;
import uk.gov.food.ratings.api.domain.Rating;
import uk.gov.food.ratings.api.domain.RatingsSummary;
import uk.gov.food.ratings.api.domain.Region;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RatingsServiceImplTest {

    @Mock
    private RatingsDao ratingsDao;

    private RatingsService ratingsService;

    @Before
    public void setUp() {
        ratingsService = new RatingsServiceImpl(ratingsDao);
    }

    @Test
    public void getRatingsSummaryForAGivenLocalAuthority() {

        // given
        String localAuthorityCode = "NLA";
        // and
        given(ratingsDao.getEstablishmentsByLocalAuthority(localAuthorityCode)).willReturn(establishments);

        // when
        List<RatingsSummary> ratingsSummaryForAGivenLocalAuthority = ratingsService.getRatingsSummaryForAGivenLocalAuthority(localAuthorityCode);

    }

    private Region createRegion(String name) {
        Region region = new Region();
        region.setName(name);
        return region;
    }

    private Establishment createEstablishment(Rating rating, LocalAuthority localAuthority) {
        Establishment establishment = new Establishment();
        establishment.setLocalAuthorityBusinessID(localAuthority.getCode());
        establishment.setRatingKey(rating.getKey());
        return establishment;
    }

    private LocalAuthority createLocalAuthorityUnder(Region region) {
        LocalAuthority localAuthority = new LocalAuthority();
        localAuthority.setCode(randomAlphabetic(10));
        localAuthority.setRegionName(region.getName());
        return localAuthority;
    }

    private Rating createRating(String key) {
        Rating rating = new Rating();
        rating.setKey(key);
        rating.setName(key);
        return rating;
    }

    private Region northRegion = createRegion("NORTH");
    private Region southRegion = createRegion("SOUTH");
    private Region eastRegion = createRegion("EAST");
    private Region westRegion = createRegion("WEST");

    private Rating fiveStarRating = createRating("5");
    Rating fourStarRating = createRating("4");
    Rating threeStarRating = createRating("3");
    Rating twoStarRating = createRating("2");
    private Rating oneStarRating = createRating("1");
    private Rating exemptStarRating = createRating("Exempt");

    LocalAuthority northLocalAuthority = createLocalAuthorityUnder(northRegion);
    Establishment northAEstablishment = createEstablishment(fiveStarRating, northLocalAuthority);
    Establishment northBEstablishment = createEstablishment(fiveStarRating, northLocalAuthority);
    Establishment northCEstablishment = createEstablishment(oneStarRating, northLocalAuthority);
    Establishment northDEstablishment = createEstablishment(exemptStarRating, northLocalAuthority);

    private List<Establishment> establishments = Stream.of(northAEstablishment, northBEstablishment,
            northCEstablishment, northDEstablishment).collect(Collectors.toList());
}