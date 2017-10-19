package uk.gov.food.ratings.api.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * LocalAuthorityRatingSummary
 */
public class LocalAuthorityRatingSummary {
    private List<RatingsSummary> ratingsSummary = null;

    private Meta meta = null;

    private List<Link> links = null;

    public LocalAuthorityRatingSummary ratingsSummary(List<RatingsSummary> ratingsSummary) {
        this.ratingsSummary = ratingsSummary;
        return this;
    }

    public LocalAuthorityRatingSummary addRatingsSummaryItem(RatingsSummary ratingsSummaryItem) {
        if (this.ratingsSummary == null) {
            this.ratingsSummary = new ArrayList<RatingsSummary>();
        }
        this.ratingsSummary.add(ratingsSummaryItem);
        return this;
    }

    public List<RatingsSummary> getRatingsSummary() {
        return ratingsSummary;
    }

    public void setRatingsSummary(List<RatingsSummary> ratingsSummary) {
        this.ratingsSummary = ratingsSummary;
    }

    public LocalAuthorityRatingSummary meta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public LocalAuthorityRatingSummary links(List<Link> links) {
        this.links = links;
        return this;
    }

    public LocalAuthorityRatingSummary addLinksItem(Link linksItem) {
        if (this.links == null) {
            this.links = new ArrayList<Link>();
        }
        this.links.add(linksItem);
        return this;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}

