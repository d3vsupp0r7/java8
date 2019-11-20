package org.lba.domain.employee.simple.app;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.lba.hibernate.jpa.util.JPAUtil;
import org.lba.model.employee.simple.Employee;

public class SimpleEmployeeDomainMainAppReadAll {

	static final Logger logger = Logger.getLogger(SimpleEmployeeDomainMainAppReadAll.class);

	public static void main(String[] args) {
		
		EntityManager entityManager = null;
		
		try {
			//
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			//
			List<Employee> listEmployees = entityManager.createQuery(
					"SELECT p FROM Employee p").getResultList();
			
			//
			entityManager.getTransaction().commit();

			if (listEmployees == null) {
				logger.debug("No Employee found. ");
			} else {
				for (Employee person : listEmployees) {
					logger.debug("Employee name= " + person.getName()
					+ ", surname:" + person.getSurname());
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
