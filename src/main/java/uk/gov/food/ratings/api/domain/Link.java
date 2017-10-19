package uk.gov.food.ratings.api.domain;

public class Link {
    private String rel;

    public String getRel() {
        return this.rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    private String href;

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}