package uk.gov.food.ratings.api;

import uk.gov.food.ratings.api.domain.LocalAuthorities;
import uk.gov.food.ratings.api.domain.RatingSummaries;
import uk.gov.food.ratings.api.domain.RatingsSummary;
import uk.gov.food.ratings.api.domain.Regions;
import uk.gov.food.ratings.api.service.RatingsEnricher;
import uk.gov.food.ratings.api.service.RatingsService;
import uk.gov.food.ratings.api.service.RatingsSorter;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("regions")
public class RatingsResource {

    private final RatingsService ratingsService;
    private final RatingsEnricher ratingsEnricher;
    private final RatingsSorter ratingsSorter;

    @Inject
    public RatingsResource(RatingsService ratingsService,
                           RatingsEnricher ratingsEnricher,
                           RatingsSorter ratingsSorter) {
        this.ratingsService = ratingsService;
        this.ratingsEnricher = ratingsEnricher;
        this.ratingsSorter = ratingsSorter;
    }

    @GET
    @Produces({"application/json"})
    public Response getRegions() {
        return createSuccessfulResponse(Regions.instance(ratingsService.getRegions()));
    }

    @GET
    @Path("/{regionName}/local-authorities")
    @Produces({"application/json"})
    public Response getLocalAuthoritiesByRegion(@PathParam("regionName") String regionName) {
        return createSuccessfulResponse(LocalAuthorities.instance(ratingsService.getLocalAuthoritiesByRegion(regionName)));
    }

    @GET
    @Path("/{regionName}/local-authorities/{localAuthorityCode}")
    @Produces({"application/json"})
    public Response getRatingsForAGivenLocalAuthority(@PathParam("regionName") String regionName,
                                                      @PathParam("localAuthorityCode") String localAuthorityCode) {
        List<RatingsSummary> enrichedRatingsSummary = ratingsEnricher.enrich(ratingsService.getRatingsSummaryForAGivenLocalAuthority(localAuthorityCode));
        ratingsSorter.sort(enrichedRatingsSummary);
        return createSuccessfulResponse(RatingSummaries.instance(enrichedRatingsSummary));
    }


    private Response createSuccessfulResponse(Object entity) {
        return Response
                .ok(entity)
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }
}
