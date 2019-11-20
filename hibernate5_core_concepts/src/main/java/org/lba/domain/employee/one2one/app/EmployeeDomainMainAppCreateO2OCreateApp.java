package org.lba.domain.employee.one2one.app;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.lba.hibernate.jpa.util.JPAUtil;
import org.lba.model.employee.one2one.EmployeeDetailEntity;
import org.lba.model.employee.one2one.EmployeeO2O;

public class EmployeeDomainMainAppCreateO2OCreateApp {

	static final Logger logger = Logger.getLogger(EmployeeDomainMainAppCreateO2OCreateApp.class);

	
	public static void main(String[] args) {

		EntityManager entityManager = null;

		try {

			//
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			//
			EmployeeDetailEntity employeeDetailEntity = new EmployeeDetailEntity();
			employeeDetailEntity.setDetailOne("Detail_One");
			employeeDetailEntity.setDetailTwo("Detail_Two");

			//
			EmployeeO2O employee = new EmployeeO2O();
			employee.setName("Thomas");
			employee.setSurname("Alva");

			
			employee.setEmployeeDetail(employeeDetailEntity);
			employeeDetailEntity.setEmployee(employee);

			// Save entity
			entityManager.persist(employee);
			entityManager.getTransaction().commit();
			logger.debug("** Employee saved successfully **");
			/*1. */
			logger.debug("** Load Employee Detail **");
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			/**/
			List<EmployeeDetailEntity> listDetail = entityManager.createQuery(
					"SELECT p FROM EmployeeDetailEntity p").getResultList();
			entityManager.getTransaction().commit();

			if (listDetail == null) {
				logger.debug("No Employee Details found. ");
				
			} else {
				
				for (EmployeeDetailEntity currentAccount : listDetail) {
					logger.debug("** Read EmployeeDetailEntity: " + currentAccount.toString() );
				}
			}
			/**/
			logger.debug("** Load Employees **");

			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			List<EmployeeO2O> listEmployees = entityManager.createQuery(
					"SELECT p FROM EmployeeO2O p").getResultList();
			//
			entityManager.getTransaction().commit();

			if (listEmployees == null) {
				logger.debug("No Employee found. ");
			} else {
				for (EmployeeO2O currentEmployee : listEmployees) {
					logger.debug("Employee: " + currentEmployee.toString());
				}
			}
			
			/**/
			entityManager.persist(employeeDetailEntity);
			
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();
			if (listEmployees == null) {
				logger.debug("No Employee found. ");
			} else {
				for (EmployeeO2O currentEmployee : listEmployees) {
					logger.debug("Employee: " + currentEmployee.toString());
					logger.debug("Employee Detail: " + currentEmployee.getEmployeeDetail().toString());
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
