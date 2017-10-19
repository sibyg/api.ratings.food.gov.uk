package uk.gov.food.ratings.api.di;

import uk.gov.food.ratings.api.dao.RatingsDao;
import uk.gov.food.ratings.api.dao.RatingsDaoStub;
import uk.gov.food.ratings.api.service.RatingsEnricher;
import uk.gov.food.ratings.api.service.RatingsService;
import uk.gov.food.ratings.api.service.RatingsServiceImpl;
import uk.gov.food.ratings.api.service.RatingsSorter;
import uk.gov.food.ratings.api.service.UKRatingsEnricher;
import uk.gov.food.ratings.api.service.UKRatingsSorter;

import org.glassfish.hk2.api.DynamicConfiguration;
import org.glassfish.hk2.utilities.Binder;
import org.glassfish.hk2.utilities.BuilderHelper;

public class DependancyBinder implements Binder {
    @Override
    public void bind(DynamicConfiguration config) {
        config.bind(BuilderHelper
                .link(RatingsServiceImpl.class)
                .to(RatingsService.class)
                .build());

        config.bind(BuilderHelper
                .link(UKRatingsEnricher.class)
                .to(RatingsEnricher.class)
                .build());

        config.bind(BuilderHelper
                .link(UKRatingsSorter.class)
                .to(RatingsSorter.class)
                .build());

        config.bind(BuilderHelper
                .link(RatingsDaoStub.class)
                .to(RatingsDao.class)
                .build());
    }
}
