package Hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class Hibernateconfig {

	public static SessionFactory getSessionFactory() {
		Properties ps = new Properties();
		
		ps.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
		ps.put(Environment.URL, "jdbc:mysql://localhost:3306/micro");
		ps.put(Environment.USER, "root");
		ps.put(Environment.PASS, "root");
		ps.put(Environment.SHOW_SQL, "true");
		ps.put(Environment.FORMAT_SQL, "true");
		ps.put(Environment.HBM2DDL_AUTO, "update");
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.applySettings(ps).build();
		// create a metadataSources and add annotated entity classes
		MetadataSources metadataSources = new MetadataSources(registry);
		metadataSources.addAnnotatedClass(Hibernate.entity.Employee.class);
		
		// create a sessionFactory 
		SessionFactory sessionFactory =metadataSources.buildMetadata().buildSessionFactory();
		
		return sessionFactory;
	}
}
