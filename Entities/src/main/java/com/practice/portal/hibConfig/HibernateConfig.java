package com.practice.portal.hibConfig;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.base.Preconditions;

@EnableTransactionManagement
public class HibernateConfig {
	
@Autowired
private Environment env;
@Autowired
private static SessionFactory sessionFactory;
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
	       LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	       sessionFactory.setDataSource(dataSource());
	       String[] strArr=env.getProperty("hibernate.setPackagesToScan").split(",");
	       sessionFactory.setPackagesToScan(strArr);
	       sessionFactory.setHibernateProperties(hibernateProperties());
	      return sessionFactory;
	    }

	private final Properties hibernateProperties() {
		// TODO Auto-generated method stub
		final Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("spring.jpa.hibernate.ddl-auto",env.getProperty("spring.jpa.hibernate.ddl-auto"));
		hibernateProperties.setProperty("spring.jpa.database-platform", env.getProperty("spring.jpa.database-platform"));
		
		return hibernateProperties;
	}
    
	@Bean
	private DataSource dataSource() {
		// TODO Auto-generated method stub
		final BasicDataSource datasource =new BasicDataSource();
		datasource.setDriverClassName(Preconditions.checkNotNull("com.mysql.jdbc.Driver"));
		datasource.setUrl(Preconditions.checkNotNull(env.getProperty("spring.datasource.url")));
		datasource.setUsername(Preconditions.checkNotNull(env.getProperty("spring.datasource.username")));
		datasource.setPassword(Preconditions.checkNotNull(env.getProperty("spring.datasource.password")));
		return datasource;
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		final HibernateTransactionManager transactionmanager=new HibernateTransactionManager();
		transactionmanager.setSessionFactory(sessionFactory().getObject());
		return transactionmanager;
		
	}
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
	    HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
	    factory.setEntityManagerFactory(emf);
	    return factory;
	}

	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
