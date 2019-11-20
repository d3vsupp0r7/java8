package org.lba.hibernate.jpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	  private static final String PERSISTENCE_UNIT_NAME = "SIMPLE_EMPLOYEE_JPA_PERSISTENCE_UNIT";
	  private static EntityManagerFactory factory;

	  public static EntityManagerFactory getEntityManagerFactory() {
	    if (factory == null) {
	      factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    }
	    return factory;
	  }

	  public static void shutdown() {
	    if (factory != null) {
	      factory.close();
	    }
	  }
	}
