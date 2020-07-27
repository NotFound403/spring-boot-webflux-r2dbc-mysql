package cn.felord.r2dbc.configuration;

import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.core.ReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;
import org.springframework.data.relational.repository.query.RelationalEntityInformation;

/**
 * 自定义R2dbcRepositoryFactory.
 */
public class CustomR2dbcRepositoryFactory extends R2dbcRepositoryFactory {
    /**
     * Creates a new {@link R2dbcRepositoryFactory} given {@link DatabaseClient} and {@link MappingContext}.
     *
     * @param databaseClient     must not be {@literal null}.
     * @param dataAccessStrategy must not be {@literal null}.
     */
    public CustomR2dbcRepositoryFactory(DatabaseClient databaseClient, ReactiveDataAccessStrategy dataAccessStrategy) {
        super(databaseClient, dataAccessStrategy);
    }

    @Override
    public <T, ID> RelationalEntityInformation<T, ID> getEntityInformation(Class<T> domainClass) {
        return super.getEntityInformation(domainClass);
    }
}
