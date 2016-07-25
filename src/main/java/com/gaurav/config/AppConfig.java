package com.gaurav.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gaurav.entity.Slot;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.gaurav")
@EnableTransactionManagement
public class AppConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {		
		BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
	    dataSource.setUrl("jdbc:hsqldb:mem://gaurav");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");	 
	    return dataSource;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    sessionBuilder.addAnnotatedClass(Slot.class);
	    sessionBuilder.addProperties(getHibernateProperties());
	    return sessionBuilder.buildSessionFactory();
	}
	
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.archive.autodetection","class");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
	    properties.put("hibernate.show_sql","true");
	    properties.put("hibernate.dialect","org.hibernate.dialect.HSQLDialect");
	    properties.put("hibernate.connection.driver_class","org.hsqldb.jdbcDriver");
	    properties.put("hibernate.connection.username","sa");
	    properties.put("hibernate.connection.password","");
	    properties.put("hibernate.connection.url","jdbc:hsqldb:mem://gaurav");
	    properties.put("hibernate.hbm2ddl.auto","create");
	    properties.put("hibernate.cache.use_second_level_cache","true");
	    properties.put("hibernate.cache.use_query_cache","true");
	    properties.put("hibernate.cache.region.factory_class","org.hibernate.cache.ehcache.EhCacheRegionFactory");
	    properties.put("hibernate.c3p0.min_size","5");
	    properties.put("hibernate.c3p0.max_size","20");
	    properties.put("hibernate.c3p0.timeout","300");
	    properties.put("hibernate.c3p0.max_statements","50");
	    properties.put("hibernate.c3p0.idle_test_period","3000");
	    properties.put("hibernate.connection.provider_class", "org.hibernate.c3p0.internal.C3P0ConnectionProvider");
	    return properties;
	}
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);	 
	    return transactionManager;
	}
}