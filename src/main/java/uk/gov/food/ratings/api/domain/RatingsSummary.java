package uk.gov.food.ratings.api.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * RatingsSummary
 */
public class RatingsSummary {
    private Rating rating = null;

    private Float percentage = null;

    private Meta meta = null;

    private List<Link> links = null;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public RatingsSummary percentage(Float percentage) {
        this.percentage = percentage;
        return this;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public RatingsSummary meta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public RatingsSummary links(List<Link> links) {
        this.links = links;
        return this;
    }

    public RatingsSummary addLinksItem(Link linksItem) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RatingsSummary{");
        sb.append("rating=").append(rating);
        sb.append(", percentage=").append(percentage);
        sb.append(", meta=").append(meta);
        sb.append(", links=").append(links);
        sb.append('}');
        return sb.toString();
    }
}

