package org.lba.randomgen.util;

import java.util.Map;
import java.util.Set;

import org.lba.randomgen.config.costraints.DayConfigEnum;
import org.lba.randomgen.config.costraints.GeneratorConfigEnum;

public class PropertyReaderSingletonUtilApp {

	public static void main(String[] args) {
		
		 //Get individual properties
		  System.out.println(PropertyReaderSingleton.getInstance().getProperty("days_into_3_month"));
		  System.out.println(PropertyReaderSingleton.getInstance().getProperty("lastName"));
		   
		  //All property names
		  System.out.println(PropertyReaderSingleton.getInstance().getAllPropertyNames());
		  
		  //All property as map
		  Map<String,String> mapOfProperty = PropertyReaderSingleton.getInstance().getAllPropertyAsMap();
		  // using for-each loop for iteration over Map.entrySet() 
	        for (Map.Entry<String,String> entry : mapOfProperty.entrySet())  {
	            System.out.println("Key = " + entry.getKey() + 
	                             ", Value = " + entry.getValue()); 
	        }
	      //Read form a map
	      System.out.println("\nRead from a map: " + mapOfProperty.get(DayConfigEnum.DAYS_INTO_3_MONTH.getValue()));
	      System.out.println("Get key from value: " + DayConfigEnum.getFromEnumValue("90"));
	      //Get a single value
	      System.out.println("**\n Get a single value given a value of property **");
	      Set<String> out = PropertyReaderSingleton.getKeysByValue(mapOfProperty,"90");
	      for (String temp : out) {
	          System.out.println("Keys: " + temp);
	       }
	      //Get a multiple value
	      System.out.println("\n** Get a multiple value given a value of property **");
	      Set<String> outs = PropertyReaderSingleton.getKeysByValue(mapOfProperty,"1");
	      for (String temp : outs) {
	          System.out.println("Keys: " + temp);
	       }
	     //Tokenized properties
	      String t1 = PropertyReaderSingleton.getInstance().getTokenizedProperty(DayConfigEnum.DAY_WITH_WEIGHT.getValue());
	      System.out.println("To tokenize: " + t1);
	      
	      //
	      try {
			String[] t2 = PropertyReaderSingleton.getInstance().getTokenizedPropertyAsStringArray(DayConfigEnum.DAY_WITH_WEIGHT.getValue(),PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.ITEM_SEPARATOR.getValue()));
			System.out.println("String[] - To tokenize: " + t2.toString() + " - size: " + t2.length);
			
			String[] t2_1 = PropertyReaderSingleton.getInstance().getTokenizedPropertyAsStringArray(DayConfigEnum.DAYS_INTO_3_MONTH.getValue(),PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.ITEM_SEPARATOR.getValue()));
			System.out.println("String[] - To tokenize: " + t2_1.toString() + " - size: " + t2_1.length);
			
			//Test exception
			//String[] t2_2 = PropertyReaderSingleton.getInstance().getTokenizedProperty("sampleProperty",PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.ITEM_SEPARATOR.getValue()));
			//System.out.println("String[] - To tokenize: " + t2_2.toString() + " - size: " + t2_2.length);
		
			Map<String,String> t3 = PropertyReaderSingleton.getInstance().getTokenizedProperty(DayConfigEnum.DAY_WITH_WEIGHT.getValue(),PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.ITEM_SEPARATOR.getValue()),PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.WEIGHT_SEPARATOR.getValue()) );
			System.out.println("String[] - To tokenize: " + t3.toString() + " - size: " + t3.size());
			
			Map<String,String> t4 = PropertyReaderSingleton.getInstance().getTokenizedProperty(DayConfigEnum.DAY_WITH_WEIGHT.getValue(),PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.ITEM_SEPARATOR.getValue()),"A" );
			System.out.println("String[] - To tokenize: " + t4.toString() + " - size: " + t4.size());
			
	      } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
