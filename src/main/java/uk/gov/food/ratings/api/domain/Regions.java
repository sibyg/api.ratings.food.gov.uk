package uk.gov.food.ratings.api.domain;

import java.util.List;

public class Regions {

    private List<Region> regions;

    public Regions() {
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public static Regions instance(List<Region> regionList) {
        Regions regionsObj = new Regions();
        regionsObj.regions = regionList;
        return regionsObj;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Regions{");
        sb.append("regions=").append(regions);
        sb.append('}');
        return sb.toString();
    }
}
