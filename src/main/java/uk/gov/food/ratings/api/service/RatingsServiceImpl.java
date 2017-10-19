package uk.gov.food.ratings.api.service;

import static java.util.stream.Collectors.groupingBy;

import uk.gov.food.ratings.api.dao.RatingsDao;
import uk.gov.food.ratings.api.domain.Establishment;
import uk.gov.food.ratings.api.domain.LocalAuthority;
import uk.gov.food.ratings.api.domain.Rating;
import uk.gov.food.ratings.api.domain.RatingsSummary;
import uk.gov.food.ratings.api.domain.Region;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class RatingsServiceImpl implements RatingsService {

    private final RatingsDao ratingsDao;

    @Inject
    public RatingsServiceImpl(RatingsDao ratingsDao) {
        this.ratingsDao = ratingsDao;
    }

    @Override
    public List<Region> getRegions() {
        return ratingsDao.getRegions();
    }

    @Override
    public List<LocalAuthority> getLocalAuthoritiesByRegion(String regionId) {
        return ratingsDao.getLocalAuthoritiesByRegion(regionId);
    }

    @Override
    public List<RatingsSummary> getRatingsSummaryForAGivenLocalAuthority(String localAuthorityCode) {
        List<Establishment> establishmentsByLocalAuthority = ratingsDao.getEstablishmentsByLocalAuthority(localAuthorityCode);
        Map<String, Long> ratingCountMap = establishmentsByLocalAuthority.stream().collect(groupingBy(Establishment::getRatingKey, Collectors.counting()));
        long sum = ratingCountMap.values().stream().mapToLong(Long::longValue).sum();
        List<RatingsSummary> ratingsSummaries = new ArrayList<>();
        ratingCountMap.forEach((ratingKey, value) -> {
            RatingsSummary ratingsSummary = new RatingsSummary();
            Rating rating = new Rating();
            rating.setKey(ratingKey);
            ratingsSummary.setRating(rating);
            ratingsSummary.setPercentage(((float) value / sum) * 100);
            ratingsSummaries.add(ratingsSummary);
        });
        return ratingsSummaries;
    }
}
