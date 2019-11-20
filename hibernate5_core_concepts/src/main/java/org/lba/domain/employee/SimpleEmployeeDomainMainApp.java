package org.lba.domain.employee;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.lba.hibernate.jpa.util.JPAUtil;
import org.lba.model.employee.simple.Employee;

public class SimpleEmployeeDomainMainApp {

	static final Logger logger = Logger.getLogger(SimpleEmployeeDomainMainApp.class);

	public static void main(String[] args) {

		EntityManager entityManager = null;

		try {
			//Obtain EntityManager
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			//Create data to persist
			Employee employee = new Employee();
			employee.setName("EmployeeName_T1");
			employee.setSurname("EmployeeSurname_T1");

			// Save entity
			entityManager.persist(employee);
			
			//Execute commit
			entityManager.getTransaction().commit();
			logger.debug("Employee saved successfully");

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
		
		//Close DB connection
		JPAUtil.shutdown();
	}

}
