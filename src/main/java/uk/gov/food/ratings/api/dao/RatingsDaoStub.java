package uk.gov.food.ratings.api.dao;

import uk.gov.food.ratings.api.domain.Establishment;
import uk.gov.food.ratings.api.domain.LocalAuthority;
import uk.gov.food.ratings.api.domain.Rating;
import uk.gov.food.ratings.api.domain.Region;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.time.DateUtils;

public class RatingsDaoStub implements RatingsDao {

    private Random random = new Random();
    private Region northRegion = createRegion(1, "NORTH");
    private Region southRegion = createRegion(2, "SOUTH");
    private Region eastRegion = createRegion(3, "EAST");
    private Region westRegion = createRegion(4, "WEST");

    private Rating fiveStarRating = createRating("5-star");
    Rating fourStarRating = createRating("4-star");
    Rating threeStarRating = createRating("3-star");
    Rating twoStarRating = createRating("2-star");
    private Rating oneStarRating = createRating("1-star");
    private Rating exemptStarRating = createRating("Exempt");

    LocalAuthority northLocalAuthorityA = createLocalAuthorityUnder(northRegion, "N-LA-A");
    Establishment northAEstablishment = createEstablishment(fiveStarRating, northLocalAuthorityA);
    Establishment northBEstablishment = createEstablishment(fiveStarRating, northLocalAuthorityA);
    Establishment northCEstablishment = createEstablishment(oneStarRating, northLocalAuthorityA);
    Establishment northDEstablishment = createEstablishment(exemptStarRating, northLocalAuthorityA);

    LocalAuthority northLocalAuthorityB = createLocalAuthorityUnder(northRegion, "N-LA-B");
    LocalAuthority northLocalAuthorityC = createLocalAuthorityUnder(northRegion, "N-LA-C");
    LocalAuthority northLocalAuthorityD = createLocalAuthorityUnder(northRegion, "N-LA-D");
    LocalAuthority northLocalAuthorityE = createLocalAuthorityUnder(northRegion, "N-LA-E");


    LocalAuthority southLocalAuthority = createLocalAuthorityUnder(southRegion, "SLA");
    Establishment southAEstablishment = createEstablishment(fiveStarRating, southLocalAuthority);
    Establishment southBEstablishment = createEstablishment(twoStarRating, southLocalAuthority);
    Establishment southCEstablishment = createEstablishment(oneStarRating, southLocalAuthority);
    Establishment southDEstablishment = createEstablishment(exemptStarRating, southLocalAuthority);


    private List<Region> regions = Stream.of(eastRegion, northRegion, southRegion, westRegion).collect(Collectors.toList());
    private List<LocalAuthority> localAuthorities = Stream.of(northLocalAuthorityA,
            northLocalAuthorityB, northLocalAuthorityC, northLocalAuthorityD, northLocalAuthorityE,
            southLocalAuthority).collect(Collectors.toList());
    private List<Establishment> establishments = Stream.of(northAEstablishment, northBEstablishment,
            northCEstablishment, northDEstablishment, southAEstablishment,
            southBEstablishment, southCEstablishment, southDEstablishment).collect(Collectors.toList());

    @Override
    public List<Region> getRegions() {
        return regions;
    }

    private Region createRegion(int id, String name) {
        Region region = new Region();
        region.setId(id);
        region.setName(name);
        return region;
    }

    private Establishment createEstablishment(Rating rating, LocalAuthority localAuthority) {
        Establishment establishment = new Establishment();
        establishment.setLocalAuthorityBusinessID(localAuthority.getCode());
        establishment.setRatingKey(rating.getKey());
        establishment.setRatingValue(Integer.toString(rating.getId()));
        return establishment;
    }

    private LocalAuthority createLocalAuthorityUnder(Region region, String code) {
        LocalAuthority localAuthority = new LocalAuthority();
        localAuthority.setId(Math.abs(random.nextInt()));
        localAuthority.setCode(code);
        localAuthority.setRegionName(region.getName());
        localAuthority.setEstablishmentCount(10);
        localAuthority.setLastPublishedDate(new Date());
        localAuthority.setCreationDate(new Date());
        return localAuthority;
    }

    private Rating createRating(String key) {
        Rating rating = new Rating();
        rating.setKey(key);
        rating.setName(key);
        return rating;
    }

    @Override
    public List<LocalAuthority> getLocalAuthoritiesByRegion(String regionName) {
        return localAuthorities.stream().filter(localAuthority -> localAuthority.getRegionName().equals(regionName)).collect(Collectors.toList());
    }

    @Override
    public List<Establishment> getEstablishmentsByLocalAuthority(String localAuthorityCode) {
        return establishments.stream().filter(establishment -> establishment.getLocalAuthorityBusinessID().equals(localAuthorityCode)).collect(Collectors.toList());
    }
}
