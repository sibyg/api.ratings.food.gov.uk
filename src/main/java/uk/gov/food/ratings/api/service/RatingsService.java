package uk.gov.food.ratings.api.service;

import uk.gov.food.ratings.api.domain.LocalAuthority;
import uk.gov.food.ratings.api.domain.RatingsSummary;
import uk.gov.food.ratings.api.domain.Region;

import java.util.List;
import java.util.Optional;

public interface RatingsService {
    List<Region> getRegions();
    List<LocalAuthority> getLocalAuthoritiesByRegion(String regionId);
    List<RatingsSummary> getRatingsSummaryForAGivenLocalAuthority(String localAuthorityCode);
}
