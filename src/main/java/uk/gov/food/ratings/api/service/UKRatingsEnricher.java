package uk.gov.food.ratings.api.service;

import uk.gov.food.ratings.api.domain.Rating;
import uk.gov.food.ratings.api.domain.RatingsSummary;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * fill in missing ratings summary for UK based Ratings
 */
public class UKRatingsEnricher implements RatingsEnricher {

    private final List<String> UK_RATINGS_CODE = Arrays.asList("5-star", "4-star", "3-star", "2-star", "1-star", "Exempt");

    @Override
    public List<RatingsSummary> enrich(List<RatingsSummary> presentRatingsSummaryList) {
        List<String> ratingsCodePresent = presentRatingsSummaryList
                .stream()
                .map(ratingsSummary -> ratingsSummary.getRating().getKey()).collect(Collectors.toList());
        List<String> ratingsCodeAbsent = UK_RATINGS_CODE.stream().filter(ratingsCode -> !ratingsCodePresent.contains(ratingsCode)).collect(Collectors.toList());
        List<RatingsSummary> absentRatingsSummary = ratingsCodeAbsent.stream().map(ratingNotPresent -> {
            RatingsSummary ratingsSummary = new RatingsSummary();
            Rating rating = new Rating();
            rating.setKey(ratingNotPresent);
            ratingsSummary.setRating(rating);
            ratingsSummary.setPercentage(0f);
            return ratingsSummary;
        }).collect(Collectors.toList());
        return Stream.concat(
                presentRatingsSummaryList.stream(),
                absentRatingsSummary.stream()).collect(Collectors.toList());
    }
}
