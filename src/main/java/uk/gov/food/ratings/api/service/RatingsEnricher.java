package uk.gov.food.ratings.api.service;

import uk.gov.food.ratings.api.domain.RatingsSummary;

import java.util.List;

/**
 * fill in missing ratings summary with 0 percentage
 */
public interface RatingsEnricher {
    List<RatingsSummary> enrich(List<RatingsSummary> ratingsSummaryList);
}
