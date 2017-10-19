package uk.gov.food.ratings.api.service;

import static java.util.Comparator.comparing;

import uk.gov.food.ratings.api.domain.RatingsSummary;

import java.util.List;

public class UKRatingsSorter implements RatingsSorter {
    @Override
    public void sort(List<RatingsSummary> ratingsSummaryList) {
        ratingsSummaryList.sort(comparing(r -> r.getRating().getKey()));
    }
}
