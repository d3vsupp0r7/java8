package org.lba.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorMainApp {

	public static void main(String[] args) {
		
		List<SampleObject> list = new ArrayList<>();
		
		/* T1 */
		list.add(new SampleObject("A1Tom", "To Send", 45));
		list.add(new SampleObject("A1Tom", "Send", 20));
		list.add(new SampleObject("A2Tom", "Failed", 10));
		list.add(new SampleObject("BTom", "Sent", 15));
		list.add(new SampleObject("CTom", "Error", 35));
		list.add(new SampleObject("A1Aom", "Failed", 21));
		/**/
		
		executeSort(list);
		
		List<SampleObject> listTwo = new ArrayList<>();
		
		/* T2 */
		listTwo.add(new SampleObject("A1Tom", "To Send", 45));
		listTwo.add(new SampleObject("A1Tom", "Send", 20));
		listTwo.add(new SampleObject("A2Tom", "Failed", 10));
		listTwo.add(new SampleObject("BTom", "Sent", 15));
		listTwo.add(new SampleObject("CTom", "Error", 35));
		listTwo.add(new SampleObject("A1Aom", "Failed", 21));
		/**/
		executeSortReverse(listTwo);
		

	}

	private static void executeSort(List<SampleObject> list) {
		System.out.println("*** Before sorting:");
		 
        for (SampleObject emp : list) {
            System.out.println(emp);
        }
 
        Collections.sort(list, new SampleObjectChainComparator(
                new NameComparator(),
                new StatusComparator(),
                new IntValueComparator())
        );
		
        System.out.println("\n*** After sorting:");
        
        for (SampleObject emp : list) {
            System.out.println(emp);
        }
	}
	
	private static void executeSortReverse(List<SampleObject> list) {
		System.out.println("\n*** Reverse Before sorting:");
		 
        for (SampleObject emp : list) {
            System.out.println(emp);
        }
 
        Collections.sort(list, new SampleObjectChainComparator(
                new NameComparator(),
                new StatusComparator(),
                new IntValueComparator()).reversed()
        );
		
        System.out.println("\n*** After sorting:");
        
        for (SampleObject emp : list) {
            System.out.println(emp);
        }
	}

}
