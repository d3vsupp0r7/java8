package org.lba.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SampleLambdaUse {

	public static void main(String[] args) {
		
		String[] machines = {"Ferrari", "Audi", "Mercedes", "Opel"};
		List<String> machineArrays =  Arrays.asList(machines);
		
		// Using lambda expression and functional operations
		System.out.println("** **");
		machineArrays.forEach((player) -> System.out.print(player + "; "));
		
		// Using double colon operator in Java 8
		System.out.println("** Double colon operator **");
		machineArrays.forEach(System.out::println);
		
		// Sort players by name using anonymous innerclass
		System.out.println("** Sorting **");
		//No lamba
		Arrays.sort(machines, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s1.compareTo(s2));
			}
		});
		//With lambda
		// Sort machines using lambda expression
		Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
		 
		Arrays.sort(machines, sortByName);
		// or this
		Arrays.sort(machines, (String s1, String s2) -> (s1.compareTo(s2)));
	}
}
