package uk.gov.food.ratings.api.domain;

import java.util.List;

public class RatingSummaries {

    private List<RatingsSummary> ratingsSummaries;

    public RatingSummaries() { }

    public List<RatingsSummary> getRatingsSummaries() {
        return ratingsSummaries;
    }

    public void setRatingsSummaries(List<RatingsSummary> ratingsSummaries) {
        this.ratingsSummaries = ratingsSummaries;
    }

    public static RatingSummaries instance(List<RatingsSummary> ratingsSummaries) {
        RatingSummaries ratingsSummariesObj = new RatingSummaries();
        ratingsSummariesObj.ratingsSummaries = ratingsSummaries;
        return ratingsSummariesObj;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RatingsSummarys{");
        sb.append("ratingsSummaries=").append(ratingsSummaries);
        sb.append('}');
        return sb.toString();
    }
}
