package vip.hoode.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author mitu2
 */
@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = DataBaseConfiguration.ENTITY_PACKAGE)
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = DataBaseConfiguration.REPOSITORY_PACKAGE)
public class DataBaseConfiguration {

    public static final String BASE_PACKAGE = "vip.hoode";
    public static final String ENTITY_PACKAGE = BASE_PACKAGE + ".entity";
    public static final String REPOSITORY_PACKAGE = BASE_PACKAGE + ".repository";

}
