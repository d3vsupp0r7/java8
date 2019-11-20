package org.lba.constraints;

public class SimpleEnumTest {

	public static void main(String[] args) {

		//Print
		System.out.println(SimpleEnum.MONDAY);

		//Iterate enum values
		System.out.println("** Enum iteration - STAR **");
		for (SimpleEnum d: SimpleEnum.values()) {
			System.out.println(d);
		}
		System.out.println("** Enum iteration - END **");

		//Variable assignment
		SimpleEnum myEnum = SimpleEnum.WEDNESDAY;
		//Use of switch/case statement
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
	}

}
