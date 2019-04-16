package com.saten.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.saten")
@EnableJpaRepositories(basePackages = "com.saten.repository")
@PropertySource({"classpath:application.properties"})
@EnableTransactionManagement
public class DatabaseConfig {

	 @Value("${spring.datasource.driver}")
	    private String driver;
	 
	    @Value("${spring.datasource.url}")
	    private String uRL;
	 
	    @Value("${spring.datasource.username}")
	    private String username;
	    
	    @Value("${spring.datasource.password}")
	    private String password;
	 
	    @Autowired
	    private Environment env;
	    
	    @Lazy
	    @Autowired
	    private LocalContainerEntityManagerFactoryBean entityManagerFactory;
	    
	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    	LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
	    	entityManagerFactory.setDataSource(dataSource());
	    	entityManagerFactory.setPackagesToScan(new String[] { "com.saten.bean" });
	        entityManagerFactory.setJpaProperties(jpaProperties());
	        HibernateJpaVendorAdapter vanderAdapter = new HibernateJpaVendorAdapter();
	        entityManagerFactory.setJpaVendorAdapter(vanderAdapter);
	        return entityManagerFactory;
	     }
		
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(driver);
	        dataSource.setUrl(uRL);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);
	        return dataSource;
	    }
	    
	    private Properties jpaProperties() {
	        Properties properties = new Properties();
	        properties.put("spring.jpa.properties.hibernate.dialect", env.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
	        properties.put("spring.jpa.show-sql", env.getRequiredProperty("spring.jpa.show-sql"));
	       // properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
	        properties.put("spring.jpa.hibernate.ddl-auto", env.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
	        return properties;
	    }
	    
		@Bean
	    public JpaTransactionManager transactionManager() {
	       JpaTransactionManager txManager = new JpaTransactionManager();
	       txManager.setEntityManagerFactory(entityManagerFactory.getObject());
	       return txManager;
	    }
		
		@Bean
		public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
			return new PersistenceExceptionTranslationPostProcessor();
		}
}
