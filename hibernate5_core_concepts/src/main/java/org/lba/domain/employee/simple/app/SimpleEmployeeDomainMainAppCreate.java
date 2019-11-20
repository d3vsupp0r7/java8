package org.lba.domain.employee.simple.app;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.lba.hibernate.jpa.util.JPAUtil;
import org.lba.model.employee.simple.Employee;

public class SimpleEmployeeDomainMainAppCreate {
	
	static final Logger logger = Logger.getLogger(SimpleEmployeeDomainMainAppCreate.class);

	public static void main(String[] args) {

	      EntityManager entityManager = null;
	      
	      try {
	    	  
	         entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	         entityManager.getTransaction().begin();

	         Employee person = new Employee();
	         person.setName("Thomas");
	         person.setSurname("Alva");
	        
	         // Save entity
	         entityManager.persist(person);

	         entityManager.getTransaction().commit();
	         System.out.println("Person saved successfully");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (entityManager != null) {
	            System.out.println("Transaction is being rolled back.");
	            entityManager.getTransaction().rollback();
	         }
	      } finally {
	         if (entityManager != null) {
	            entityManager.close();
	         }
	      }
	      JPAUtil.shutdown();
	   }

}
