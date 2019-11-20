package org.lba.randomgen.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.lba.randomgen.config.costraints.GeneratorConfigEnum;

public class PropertyReaderSingleton {

	static final Logger logger = Logger.getLogger(PropertyReaderSingleton.class);
	//
	private static PropertyReaderSingleton instance = null;
	private final Properties configProp = new Properties();

	private PropertyReaderSingleton() {

		String propFileName = "config-generator.properties";

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			try {
				configProp.load(inputStream);
			} catch (IOException e) {
				logger.debug("Property file '" + propFileName + "' not found in the classpath");
			}

		}
	}

	public static PropertyReaderSingleton getInstance(){
		if (instance == null) {
			instance = new PropertyReaderSingleton();
		}
		return instance;
	}

	public String getProperty(String key){
		return configProp.getProperty(key);
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public String getTokenizedProperty(String key){
		String fromProperty = configProp.getProperty(key);

		String[] tokens = fromProperty.split(GeneratorConfigEnum.ITEM_SEPARATOR.getValue());

		for (String token : tokens)
		{
			System.out.println(token);
		}

		return configProp.getProperty(key);
	}


	public String[] getTokenizedPropertyAsStringArray(String key,String tokenSeparator1) throws Exception{

		String fromProperty = configProp.getProperty(key);

		if(fromProperty==null) {
			throw new Exception("Property " + key + " not found!");
		}

		String[] tokens = fromProperty.split(tokenSeparator1);

		if(tokens.length == 0 || !fromProperty.contains(tokenSeparator1)) {
			throw new Exception("Property " + key + " has no token for separator: " + tokenSeparator1);
		}
		return tokens;
	}

	/**
	 * 
	 * @param key
	 * @param tokenSeparator1
	 * @param tokenSeparator2
	 * @return
	 * @throws Exception 
	 */
	public Map<String,String> getTokenizedProperty(String key,String tokenSeparator1, String tokenSeparator2) throws Exception{

		Map<String,String> toReturn = new HashMap<>();
		
		String fromProperty = configProp.getProperty(key);

		if(fromProperty==null) {
			throw new Exception("Property " + key + " not found!");
		}

		String[] tokens = fromProperty.split(tokenSeparator1);

		if(tokens.length == 0 || !fromProperty.contains(tokenSeparator2) ) {
			throw new Exception("Property " + key + " has no token for separator: " + tokenSeparator1);
		}
		
		for (String currentMultitokenString : tokens) {
			
			String[] tokens2 = currentMultitokenString.split(tokenSeparator2);
			
			if(tokens2.length == 0 || !currentMultitokenString.contains(tokenSeparator2)) {
				throw new Exception("Property " + key + " has no token for separator: " + tokenSeparator2);
			}
			
			toReturn.put(tokens2[0], tokens2[1]);
		}
		
		return toReturn;
	}

	public Set<String> getAllPropertyNames(){
		return configProp.stringPropertyNames();
	}

	public boolean containsKey(String key){
		return configProp.containsKey(key);
	}

	public  Map<String,String> getAllPropertyAsMap()
	{
		Map<String,String>map = new HashMap<>();

		for (final Entry<Object, Object> entry : configProp.entrySet()) {
			map.put((String) entry.getKey(), (String) entry.getValue());
		}
		return map;
	}

	public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
		Set<T> keys = new HashSet<>();
		for (Entry<T, E> entry : map.entrySet()) {
			if (Objects.equals(value, entry.getValue())) {
				keys.add(entry.getKey());
			}
		}
		return keys;
	}

}
