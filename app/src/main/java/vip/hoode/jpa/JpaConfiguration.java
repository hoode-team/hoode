package vip.hoode.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

/**
 * @author mitu2
 */
@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = JpaConfiguration.ENTITY_PACKAGE)
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = JpaConfiguration.REPOSITORY_PACKAGE)
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class JpaConfiguration {

    public static final String BASE_PACKAGE = "vip.hoode.jpa";
    public static final String ENTITY_PACKAGE = BASE_PACKAGE + ".entity";
    public static final String REPOSITORY_PACKAGE = BASE_PACKAGE + ".repository";

}
