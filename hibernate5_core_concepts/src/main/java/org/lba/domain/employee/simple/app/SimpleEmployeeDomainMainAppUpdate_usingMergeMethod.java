package org.lba.domain.employee.simple.app;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.lba.hibernate.jpa.util.JPAUtil;
import org.lba.model.employee.simple.Employee;

public class SimpleEmployeeDomainMainAppUpdate_usingMergeMethod {

	static final Logger logger = Logger.getLogger(SimpleEmployeeDomainMainAppUpdate_usingMergeMethod.class);
	
	 public static void main(String[] args) {

	      EntityManager entityManager = null;
	      
	      try {
	    	  
	    	 //
	         entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	         entityManager.getTransaction().begin();

	         Employee employee = entityManager.find(Employee.class, 10001l);
	         
	         //Detach entity
	         entityManager.clear();
	         
	         //Execute update
	         employee.setName("Name_Updated");
	         entityManager.merge(employee);

	         entityManager.getTransaction().commit();
	         logger.debug("** Employee updated successfully **");
	         
	         /*Reopen transaction after commit of previous operation*/
	         entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	         entityManager.getTransaction().begin();
	         
	         logger.debug("** List all employees **");
	         
	         List<Employee> listEmployees = entityManager.createQuery(
	                 "SELECT p FROM Employee p").getResultList();
	         entityManager.getTransaction().commit();
	         
	         if (listEmployees == null) {
	         
	        	 logger.debug("No Employee found. ");
	         } else {
	        	 
	             for (Employee currentEmployee : listEmployees) {
	            	 logger.debug("Employee name= " + currentEmployee.getName()
	                     + ", surname:" + currentEmployee.getSurname());
	             }
	         }
	         
	      } catch (Exception e) {
	    	  
	         e.printStackTrace();
	         
	         if (entityManager != null) {
	        	 logger.debug("Transaction is being rolled back.");
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
