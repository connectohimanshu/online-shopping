package net.kzm.shoppingbackend.config;




import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"net.kzm.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	//changes the below based on database used	
//	private final static String  DATABASE_URL = "jdbc:mysql://inpits.c0xkfiq0rfxf.ap-south-1.rds.amazonaws.com:3306/SpringMvcTutorial";
//	private final static String  DATABASE_DRIVER = "com.mysql.jdbc.Driver";
//	private final static String  DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
//	private final static String  DATABASE_USERNAME = "inpits";
//	private final static String  DATABASE_PASSWORD = "inpits123";
//	
	
	private final static String  DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String  DATABASE_DRIVER = "org.h2.Driver";
	private final static String  DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String  DATABASE_USERNAME = "sa";
	private final static String  DATABASE_PASSWORD = "";
	
	//initialising datasource bean
	@Bean
	public DataSource getDataSource()
	{
		BasicDataSource dataSource = new BasicDataSource();
		
		
		//providing the database connection input
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	
	//initialising sessionfactory bean
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.kzm.shoppingbackend.dto");
		
		return builder.buildSessionFactory();
	}

	//All hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		// TODO Auto-generated method stub
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.format_sql","true");
		return properties;
	}
	
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;  
	}
}
