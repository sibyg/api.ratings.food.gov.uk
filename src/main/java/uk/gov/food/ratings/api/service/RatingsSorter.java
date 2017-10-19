package uk.gov.food.ratings.api.service;

import uk.gov.food.ratings.api.domain.RatingsSummary;

import java.util.List;

public interface RatingsSorter {
    void sort(List<RatingsSummary> ratingsSummaryList);
}
