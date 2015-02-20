package com.lenore.dappad.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@EnableJpaRepositories("com.lenore.dappad.dao")
@PropertySource("classpath:/jdbc.properties")
@ComponentScan({ "com.lenore.dappad" })
public class DataBaseConfig {

    private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
         
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

    @Autowired
    private Environment env;

    public DataBaseConfig() {
        super();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource restDataSource() {
        final BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

        return dataSource;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory) {
        final HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    final Properties hibernateProperties() {
        final Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty(PROPERTY_NAME_HIBERNATE_DIALECT));

        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        // hibernateProperties.setProperty("hibernate.format_sql", "true");
        // hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");

        return hibernateProperties;
    }

}
