package org.lba.constraints;

public class SimpleEnumWithInstanceFieldTest {

	public static void main(String[] args) {

		//Print
		System.out.println(SimpleEnumWithInstanceField.MONDAY);
		System.out.println(SimpleEnumWithInstanceField.MONDAY.field());

		//Iterate enum values
		System.out.println("** Enum iteration - STAR **");
		for (SimpleEnumWithInstanceField d: SimpleEnumWithInstanceField.values()) {
			System.out.println(d);
		}
		System.out.println("** Enum iteration - END **");

		//Variable assignment
		SimpleEnumWithInstanceField myEnum = SimpleEnumWithInstanceField.WEDNESDAY;
		//Use of switch/case statement
		System.out.println("** Switch/case iteration - START **");
		switch (myEnum) {
		case MONDAY:
			System.out.println("It's MONDAY");
			break;
		case TUESDAY:
			System.out.println("It's TUESDAY");
			break;
		case WEDNESDAY:
			System.out.println("It's WEDNESDAY");
			break;
		case THURSDAY:  
			System.out.println("It's THURSDAY");
			break;
		case FRIDAY:
			System.out.println("It's FRIDAY");
			break;
		case SATURDAY:
			System.out.println("It's SATURDAY");
			break;
		case SUNDAY:    	
			System.out.println("It's SUNDAY");
			break;
		default:       
			System.out.println("What day is it?");
		}
		System.out.println("** Switch/case iteration - END **");

		//
		String sampleEnumValue = "SATURDAY_VALUE";
		SimpleEnumWithInstanceField sampleEnumFromValue = SimpleEnumWithInstanceField.getFromEnumValue(sampleEnumValue);
		System.out.println("** sampleEnumFromValue: " + sampleEnumFromValue.toString() + " **");
		//
		String sampleEnumKey = "SUNDAY";
		SimpleEnumWithInstanceField sampleEnumFromKey = SimpleEnumWithInstanceField.getFromEnumKey(sampleEnumKey);
		System.out.println("** sampleEnumFromKey: " + sampleEnumFromKey.toString() + " **");
		
	}

}
