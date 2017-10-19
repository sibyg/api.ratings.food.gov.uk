package uk.gov.food.ratings.api.domain;

import java.util.List;

public class Rating {

    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String key;

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private String keyName;

    public String getKeyName() {
        return this.keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    private int schemeTypeId;

    public int getSchemeTypeId() {
        return this.schemeTypeId;
    }

    public void setSchemeTypeId(int schemeTypeId) {
        this.schemeTypeId = schemeTypeId;
    }

    private List<Link> links;

    public List<Link> getLinks() {
        return this.links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rating{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", key='").append(key).append('\'');
        sb.append(", keyName='").append(keyName).append('\'');
        sb.append(", schemeTypeId=").append(schemeTypeId);
        sb.append(", links=").append(links);
        sb.append('}');
        return sb.toString();
    }
}
