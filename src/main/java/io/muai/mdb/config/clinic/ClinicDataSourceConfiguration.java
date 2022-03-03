package io.muai.mdb.config.clinic;


import io.muai.mdb.model.clinic.Clinic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"io.muai.mdb.repos.clinic"},
        entityManagerFactoryRef = "clinicEntityManagerFactory",
        transactionManagerRef = "clinicTransactionManager"
)
public class ClinicDataSourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "bumblebee-datasource")
    public DataSource clinicsDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/bumblebee");
        dataSource.setUsername("test");
        dataSource.setPassword("test");
        return dataSource;
    }

    @Bean
    @Primary
    LocalContainerEntityManagerFactoryBean clinicEntityManagerFactory(
            @Qualifier("clinicsDataSource") DataSource clinicsDatasource, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(clinicsDatasource).packages(Clinic.class).build();
    }

    @Bean
    @Primary
    PlatformTransactionManager clinicTransactionManager(
            @Qualifier("clinicEntityManagerFactory") LocalContainerEntityManagerFactoryBean clinicEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(clinicEntityManagerFactory.getObject()));
    }
}
