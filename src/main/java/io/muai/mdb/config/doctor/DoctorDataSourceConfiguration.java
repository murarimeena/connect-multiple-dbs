package io.muai.mdb.config.doctor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        basePackages = {"io.muai.mdb.repos.doctor"},
        entityManagerFactoryRef = "doctorEntityManagerFactory",
        transactionManagerRef = "doctorTransactionManager"
)
public class DoctorDataSourceConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "arcticfox-datasource")
    DataSource doctorsDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/arcticfox");
        dataSource.setUsername("test");
        dataSource.setPassword("test");
        return dataSource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean doctorEntityManagerFactory(
            @Qualifier("doctorsDatasource") DataSource doctorsDatasource, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(doctorsDatasource).packages("io.muai.mdb.model.doctor").build();
    }

    @Bean
    PlatformTransactionManager doctorTransactionManager(
            @Qualifier("doctorEntityManagerFactory") LocalContainerEntityManagerFactoryBean doctorEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(doctorEntityManagerFactory.getObject()));
    }
}