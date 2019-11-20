package org.lba.domain.employee.simple.app;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.lba.hibernate.jpa.util.JPAUtil;
import org.lba.model.employee.simple.Employee;

public class SimpleEmployeeDomainMainAppFindById {

	static final Logger logger = Logger.getLogger(SimpleEmployeeDomainMainAppFindById.class);
	
	public static void main(String[] args) {
		
		EntityManager entityManager = null;
		
		try {
			
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			Employee employee = entityManager.find(Employee.class, 10001l);
			
			entityManager.getTransaction().commit();

			if (employee == null) {
				
				logger.debug("No Employee found. ");
			} else {
			
				logger.debug("** Employee found **");
				logger.debug("Employee name= " + employee.getName()
				+ ", surname:" + employee.getSurname());
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
