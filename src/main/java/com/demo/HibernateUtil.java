package com.demo;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateUtil {

	@Autowired
	private Environment environment;

	@Bean
	DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.out.println(environment.getProperty("db.driver"));
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;

	}

	private Properties initializeHibernateProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dailect", "org.hibernate.dialect.MySQL5Dialect");
		hibernateProp.put("hibernate.show_sql", "true");
		hibernateProp.put("hibernate.format_sql", "false");
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		return hibernateProp;
	}

	@Bean
	LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.demo.*");
		sessionFactory.setHibernateProperties(initializeHibernateProperties());
		return sessionFactory;
	}

	@Bean
	@Autowired
	HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

}
