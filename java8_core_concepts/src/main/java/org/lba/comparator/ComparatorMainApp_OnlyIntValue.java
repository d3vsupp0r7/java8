package org.lba.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorMainApp_OnlyIntValue {

	public static void main(String[] args) {
		
		List<SampleObject> list = new ArrayList<>();
		
		/* T1 */
		list.add(new SampleObject("A1Tom", "To Send", 45, false));
		list.add(new SampleObject("A1Tom", "To Send", 41, false));
		list.add(new SampleObject("A1Toms", "To Send", 47, false));
		list.add(new SampleObject("A1Tomz", "To Send", 20, true));
		list.add(new SampleObject("A1TomZ", "Send", 20, true));
		list.add(new SampleObject("A1Tomp", "To Send", 20, true));
		list.add(new SampleObject("A1Tome", "Send", 20, true));
		list.add(new SampleObject("A2Toma", "Failed", 10, false));
		list.add(new SampleObject("BTom", "Sent", 15,true));
		list.add(new SampleObject("CTom", "Error", 35,false));
		list.add(new SampleObject("A1Aom", "Failed", 21, false));
		/**/
		
		executeSort(list);
		
		List<SampleObject> listTwo = new ArrayList<>();
		
		/* T2 */
		listTwo.add(new SampleObject("A1Tom", "To Send", 45, false));
		listTwo.add(new SampleObject("A1Tom", "Send", 20, true));
		listTwo.add(new SampleObject("A2Tom", "Failed", 10, false));
		listTwo.add(new SampleObject("BTom", "Sent", 15,true));
		listTwo.add(new SampleObject("CTom", "Error", 35,false));
		listTwo.add(new SampleObject("A1Aom", "Failed", 21, false));
		/**/
		executeSortReverse(listTwo);
		

	}

	private static void executeSort(List<SampleObject> list) {
		System.out.println("*** Before sorting:");
		 
        for (SampleObject emp : list) {
            System.out.println(emp);
        }
 
        Collections.sort(list, new SampleObjectChainComparator(
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
        		new IntValueComparator()).reversed()
        );
		
        System.out.println("\n*** After sorting:");
        
        for (SampleObject emp : list) {
            System.out.println(emp);
        }
	}

}
