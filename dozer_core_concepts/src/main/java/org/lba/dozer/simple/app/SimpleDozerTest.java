package org.lba.dozer.simple.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.lba.dozer.simple.destination.DestinationObject;
import org.lba.dozer.simple.source.SourceObject;

public class SimpleDozerTest {

	static final Logger logger = Logger.getLogger(SimpleDozerTest.class);
	
	public static void main(String[] args) {
		
		//Load Dozer configuration mapping file
		List<String> mappingFiles = new ArrayList<>();
	    mappingFiles.add("simpleDozerMapping.xml");
	    
	    //define the dozer env
	    DozerBeanMapper mapper = new DozerBeanMapper();
	    mapper.setMappingFiles(mappingFiles);

	    //Define a source object
	    SourceObject sourceObject = new SourceObject();
	    sourceObject.setName("EmployeeName");
	    sourceObject.setAge(28);
	    sourceObject.setCity("EmployeeCity");

	    //Clone fields of SourceObject into DestinationObject 
	    DestinationObject destObject = mapper.map(sourceObject, DestinationObject.class);

	    logger.debug("Destination object: " + destObject.toString() );
	    
	}

}
