package uk.gov.food.ratings.api.domain;

import java.util.List;

public class LocalAuthorities {

    private List<LocalAuthority> localAuthorities;

    public LocalAuthorities() {
    }

    public void setLocalAuthorities(List<LocalAuthority> localAuthorities) {
        this.localAuthorities = localAuthorities;
    }

    public List<LocalAuthority> getLocalAuthorities() {
        return localAuthorities;
    }

    public static LocalAuthorities instance(List<LocalAuthority> localAuthoritiesList) {
        LocalAuthorities localAuthoritiesObj = new LocalAuthorities();
        localAuthoritiesObj.localAuthorities = localAuthoritiesList;
        return localAuthoritiesObj;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LocalAuthorities{");
        sb.append("localAuthorities=").append(localAuthorities);
        sb.append('}');
        return sb.toString();
    }
}
