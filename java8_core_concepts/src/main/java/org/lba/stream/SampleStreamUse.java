package org.lba.stream;

import java.util.Arrays;
import java.util.List;

public class SampleStreamUse {

	public static void main(String[] args) {

		//Given a list
		List<String> list = Arrays.asList("A", "B", "C");
		//Get a stream from a list
		list.stream().forEach(System.out::println);
		//
		list.stream().forEach( currVar -> {
			if(currVar.equals("B")) {
				System.out.println("B was processed");
			}
		});
		
	}

}
