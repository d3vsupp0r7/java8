package org.lba.domain.employee.one2many.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.lba.hibernate.jpa.util.JPAUtil;
import org.lba.model.employee.one2many.AccountEntity;
import org.lba.model.employee.one2many.EmployeeO2M;

public class EmployeeDomainMainAppCreateO2MCreateApp {

	static final Logger logger = Logger.getLogger(EmployeeDomainMainAppCreateO2MCreateApp.class);

	
	public static void main(String[] args) {

		EntityManager entityManager = null;

		try {

			//
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			//
			AccountEntity account1 = new AccountEntity();
			account1.setAccountNumber("Account detail 1");

			AccountEntity account2 = new AccountEntity();
			account2.setAccountNumber("Account detail 2");

			AccountEntity account3 = new AccountEntity();
			account3.setAccountNumber("Account detail 3");

			//
			EmployeeO2M employee = new EmployeeO2M();
			employee.setName("Thomas");
			employee.setSurname("Alva");

			List<AccountEntity> list = new ArrayList<>();
			list.add(account1);
			list.add(account2);

			employee.setAccounts(list);

			// Save entity
			entityManager.persist(employee);
			entityManager.getTransaction().commit();
			logger.debug("** Employee saved successfully **");
			/*1. */
			logger.debug("** Load Accounts **");
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			/**/
			List<AccountEntity> listAccounts = entityManager.createQuery(
					"SELECT p FROM ForeignKeyAssoAccountEntity p").getResultList();
			entityManager.getTransaction().commit();

			if (listAccounts == null) {
				logger.debug("No Employee found. ");
				
			} else {
				
				for (AccountEntity currentAccount : listAccounts) {
					logger.debug("** Read AccountEntity: " + currentAccount.toString() );
				}
			}
			/**/
			logger.debug("** Load Employees **");

			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			List<EmployeeO2M> listEmployees = entityManager.createQuery(
					"SELECT p FROM EmployeeO2M p").getResultList();
			//
			entityManager.getTransaction().commit();

			if (listEmployees == null) {
				logger.debug("No Employee found. ");
			} else {
				for (EmployeeO2M person : listEmployees) {
					logger.debug("Employee: " + employee.toString());
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
