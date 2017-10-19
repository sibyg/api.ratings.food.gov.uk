package uk.gov.food.ratings.api.domain;

import java.util.Date;
import java.util.List;

public class LocalAuthority {
    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String code;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String friendlyName;

    public String getFriendlyName() {
        return this.friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String Url) {
        this.url = Url;
    }

    private String schemaUrl;

    public String getSchemeUrl() {
        return this.schemaUrl;
    }

    public void setSchemeUrl(String schemeUrl) {
        this.schemaUrl = schemeUrl;
    }

    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String regionName;

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String fileNameWelsh;

    public String getFileNameWelsh() {
        return this.fileNameWelsh;
    }

    public void setFileNameWelsh(String fileNameWelsh) {
        this.fileNameWelsh = fileNameWelsh;
    }

    private int establishmentCount;

    public int getEstablishmentCount() {
        return this.establishmentCount;
    }

    public void setEstablishmentCount(int establishmentCount) {
        this.establishmentCount = establishmentCount;
    }

    private Date creationDate;

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    private Date lastPublishedDate;

    public Date getLastPublishedDate() {
        return this.lastPublishedDate;
    }

    public void setLastPublishedDate(Date lastPublishedDate) {
        this.lastPublishedDate = lastPublishedDate;
    }

    private int schemeType;

    public int getSchemeType() {
        return this.schemeType;
    }

    public void setSchemeType(int schemeType) {
        this.schemeType = schemeType;
    }

    private List<Link> links;

    public List<Link> getLinks() {
        return this.links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}