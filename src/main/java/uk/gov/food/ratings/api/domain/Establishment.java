package uk.gov.food.ratings.api.domain;

import java.util.Date;
import java.util.List;

public class Establishment {

    private int FHRSID;

    public int getFHRSID() {
        return this.FHRSID;
    }

    public void setFHRSID(int FHRSID) {
        this.FHRSID = FHRSID;
    }

    private String LocalAuthorityBusinessID;

    public String getLocalAuthorityBusinessID() {
        return this.LocalAuthorityBusinessID;
    }

    public void setLocalAuthorityBusinessID(String LocalAuthorityBusinessID) {
        this.LocalAuthorityBusinessID = LocalAuthorityBusinessID;
    }

    private String BusinessName;

    public String getBusinessName() {
        return this.BusinessName;
    }

    public void setBusinessName(String BusinessName) {
        this.BusinessName = BusinessName;
    }

    private String BusinessType;

    public String getBusinessType() {
        return this.BusinessType;
    }

    public void setBusinessType(String BusinessType) {
        this.BusinessType = BusinessType;
    }

    private int BusinessTypeID;

    public int getBusinessTypeID() {
        return this.BusinessTypeID;
    }

    public void setBusinessTypeID(int BusinessTypeID) {
        this.BusinessTypeID = BusinessTypeID;
    }

    private String AddressLine1;

    public String getAddressLine1() {
        return this.AddressLine1;
    }

    public void setAddressLine1(String AddressLine1) {
        this.AddressLine1 = AddressLine1;
    }

    private String AddressLine2;

    public String getAddressLine2() {
        return this.AddressLine2;
    }

    public void setAddressLine2(String AddressLine2) {
        this.AddressLine2 = AddressLine2;
    }

    private String AddressLine3;

    public String getAddressLine3() {
        return this.AddressLine3;
    }

    public void setAddressLine3(String AddressLine3) {
        this.AddressLine3 = AddressLine3;
    }

    private String AddressLine4;

    public String getAddressLine4() {
        return this.AddressLine4;
    }

    public void setAddressLine4(String AddressLine4) {
        this.AddressLine4 = AddressLine4;
    }

    private String PostCode;

    public String getPostCode() {
        return this.PostCode;
    }

    public void setPostCode(String PostCode) {
        this.PostCode = PostCode;
    }

    private String Phone;

    public String getPhone() {
        return this.Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    private String RatingValue;

    public String getRatingValue() {
        return this.RatingValue;
    }

    public void setRatingValue(String RatingValue) {
        this.RatingValue = RatingValue;
    }

    private String RatingKey;

    public String getRatingKey() {
        return this.RatingKey;
    }

    public void setRatingKey(String RatingKey) {
        this.RatingKey = RatingKey;
    }

    private Date RatingDate;

    public Date getRatingDate() {
        return this.RatingDate;
    }

    public void setRatingDate(Date RatingDate) {
        this.RatingDate = RatingDate;
    }

    private String LocalAuthorityCode;

    public String getLocalAuthorityCode() {
        return this.LocalAuthorityCode;
    }

    public void setLocalAuthorityCode(String LocalAuthorityCode) {
        this.LocalAuthorityCode = LocalAuthorityCode;
    }

    private String LocalAuthorityName;

    public String getLocalAuthorityName() {
        return this.LocalAuthorityName;
    }

    public void setLocalAuthorityName(String LocalAuthorityName) {
        this.LocalAuthorityName = LocalAuthorityName;
    }

    private String LocalAuthorityWebSite;

    public String getLocalAuthorityWebSite() {
        return this.LocalAuthorityWebSite;
    }

    public void setLocalAuthorityWebSite(String LocalAuthorityWebSite) {
        this.LocalAuthorityWebSite = LocalAuthorityWebSite;
    }

    private String LocalAuthorityEmailAddress;

    public String getLocalAuthorityEmailAddress() {
        return this.LocalAuthorityEmailAddress;
    }

    public void setLocalAuthorityEmailAddress(String LocalAuthorityEmailAddress) {
        this.LocalAuthorityEmailAddress = LocalAuthorityEmailAddress;
    }

    private Scores scores;

    public Scores getScores() {
        return this.scores;
    }

    public void setScores(Scores scores) {
        this.scores = scores;
    }

    private String SchemeType;

    public String getSchemeType() {
        return this.SchemeType;
    }

    public void setSchemeType(String SchemeType) {
        this.SchemeType = SchemeType;
    }

    private Geocode geocode;

    public Geocode getGeocode() {
        return this.geocode;
    }

    public void setGeocode(Geocode geocode) {
        this.geocode = geocode;
    }

    private String RightToReply;

    public String getRightToReply() {
        return this.RightToReply;
    }

    public void setRightToReply(String RightToReply) {
        this.RightToReply = RightToReply;
    }

    private double Distance;

    public double getDistance() {
        return this.Distance;
    }

    public void setDistance(double Distance) {
        this.Distance = Distance;
    }

    private boolean NewRatingPending;

    public boolean getNewRatingPending() {
        return this.NewRatingPending;
    }

    public void setNewRatingPending(boolean NewRatingPending) {
        this.NewRatingPending = NewRatingPending;
    }

    private Meta meta;

    public Meta getMeta() {
        return this.meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    private List<Link> links;

    public List<Link> getLinks() {
        return this.links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}