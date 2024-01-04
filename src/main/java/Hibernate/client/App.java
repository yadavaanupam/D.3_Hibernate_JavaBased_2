package Hibernate.client;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import Hibernate.entity.Employee;
import Hibernate.util.Hibernateconfig;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		Employee Anupam=new Employee();
		// Anupam.setId(1);
//		Anupam.setName("Ritika");
//		Anupam.setGender("Female");
//		Anupam.setSalary(45000);
//		
		//
		
		SessionFactory sf =Hibernateconfig.getSessionFactory();
		Session session= sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Program Start........");
//		//Employee e = new Employee();

		
		// Example of HQL to get all the records
		Query query1=session.createQuery("from Employee");
		 List list =query1.list();
		 System.out.println(list);
		 
		 Query q =session.createQuery("select max(name)from Employee");
		 List<Integer> list1=q.list();
		 System.out.println(list1.get(0));
		 
//			HQL to get records with pagination
			Query query2=session.createQuery("from Employee");  
			query2.setFirstResult(1);  
			query2.setMaxResults(3);  
			List list2=query2.list();//will return the records from 5 to 10th number  
			System.out.println("2 to 4: "+list2);
			
//			HQL update query Using Named Parameters
			Query q1=session.createQuery("update Employee set name=:n where id=:i");  
			q.setParameter("n","Udit kumar");  
			q.setParameter("i",1);  
			System.out.println("status: "+q1.executeUpdate());  

//			HQL delete query
//			Query query=session.createQuery("delete from Employee where id= 20");  
//			query.executeUpdate();  
			
//			Query query1=session.createQuery("from Employee");
//			List list=query1.list();  
//			System.out.println(list);

		// session.save(Anupam);
			tx.commit();
			
			 session.close();
			  sf.close();
		 

	}

}
