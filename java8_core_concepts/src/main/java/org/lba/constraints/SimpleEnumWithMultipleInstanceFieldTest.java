package org.lba.constraints;

public class SimpleEnumWithMultipleInstanceFieldTest {

	public static void main(String[] args) {

		//Print
		System.out.println(SimpleEnumWithMultipleInstanceField.MONDAY);
		System.out.println(SimpleEnumWithMultipleInstanceField.MONDAY.field());
		System.out.println(SimpleEnumWithMultipleInstanceField.MONDAY.getNumber());

		//Iterate enum values
		System.out.println("** Enum iteration - STAR **");
		for (SimpleEnumWithMultipleInstanceField d: SimpleEnumWithMultipleInstanceField.values()) {
			System.out.println(d);
		}
		System.out.println("** Enum iteration - END **");

		//Variable assignment
		SimpleEnumWithMultipleInstanceField myEnum = SimpleEnumWithMultipleInstanceField.WEDNESDAY;
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
		SimpleEnumWithMultipleInstanceField sampleEnumFromValue = SimpleEnumWithMultipleInstanceField.getFromEnumStringValue(sampleEnumValue);
		System.out.println("** sampleEnumFromValue: " + sampleEnumFromValue.toString() + " **");
		//
		String sampleEnumKey = "SUNDAY";
		SimpleEnumWithMultipleInstanceField sampleEnumFromKey = SimpleEnumWithMultipleInstanceField.getFromEnumKey(sampleEnumKey);
		System.out.println("** sampleEnumFromKey: " + sampleEnumFromKey.toString() + " **");
		//
		int sampleIntValue = 5;
		SimpleEnumWithMultipleInstanceField sampleEnumFromIntValue = SimpleEnumWithMultipleInstanceField.getFromEnumIntValue(sampleIntValue);
		System.out.println("** sampleEnumFromIntValue: " + sampleEnumFromIntValue.toString() + " **");
		//
		SimpleEnumWithMultipleInstanceField sampleEnumFromIntValueOut = SimpleEnumWithMultipleInstanceField.valueOfNumber(3);
		System.out.println("** sampleEnumFromIntValueOut: " + sampleEnumFromIntValueOut.toString() + " **");
	}

}
