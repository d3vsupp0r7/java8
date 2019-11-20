package org.lba.dozer.simple.annotated.app;

import org.apache.log4j.Logger;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.lba.dozer.simple.annotated.destination.AnnotatedDestinationObject;
import org.lba.dozer.simple.annotated.source.AnnotatedSourceObject;

public class SimpleDozerAnnotatedTest {

	static final Logger logger = Logger.getLogger(SimpleDozerAnnotatedTest.class);

	public static void main(String[] args) {
		
		// Create a Mapper Object
		Mapper mapper = new DozerBeanMapper();
 
		AnnotatedSourceObject sourceBean = new AnnotatedSourceObject();
		sourceBean.setId(1);
		sourceBean.setName("SampleName");
		sourceBean.setCity("SampleField");
		sourceBean.setFieldOnlyOnSource("Only on sourceBean");
		sourceBean.setGenericStringField("A generic field");
 
		// Use the mapper Object and then map the required object
		AnnotatedDestinationObject destBean = mapper.map(sourceBean, AnnotatedDestinationObject.class);
 
		logger.debug(destBean);

	}

}
