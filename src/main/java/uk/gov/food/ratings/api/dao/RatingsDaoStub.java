package uk.gov.food.ratings.api.dao;

import uk.gov.food.ratings.api.data.Stub;
import uk.gov.food.ratings.api.domain.Establishment;
import uk.gov.food.ratings.api.domain.LocalAuthority;
import uk.gov.food.ratings.api.domain.Region;

import java.util.List;
import java.util.stream.Collectors;

public class RatingsDaoStub implements RatingsDao {

    public Stub stub = new Stub();

    @Override
    public List<Region> getRegions() {
        return stub.regions;
    }


    @Override
    public List<LocalAuthority> getLocalAuthoritiesByRegion(String regionName) {
        return stub.localAuthorities.stream().filter(localAuthority -> localAuthority.getRegionName().equals(regionName)).collect(Collectors.toList());
    }

    @Override
    public List<Establishment> getEstablishmentsByLocalAuthority(String localAuthorityCode) {
        return stub.establishments.stream().filter(establishment -> establishment.getLocalAuthorityBusinessID().equals(localAuthorityCode)).collect(Collectors.toList());
    }
}
