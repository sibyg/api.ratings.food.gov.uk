package uk.gov.food.ratings.api.dao;

import uk.gov.food.ratings.api.domain.Establishment;
import uk.gov.food.ratings.api.domain.LocalAuthority;
import uk.gov.food.ratings.api.domain.Region;

import java.util.List;

public interface RatingsDao {
    List<Region> getRegions();

    List<LocalAuthority> getLocalAuthoritiesByRegion(String regionId);

    List<Establishment> getEstablishmentsByLocalAuthority(String localAuthorityId);
}
